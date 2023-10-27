package com.ertikmen.service;


import com.ertikmen.dto.request.ActivateRequestDto;
import com.ertikmen.dto.request.AuthUpdateRequestDto;
import com.ertikmen.dto.request.LoginRequestDto;
import com.ertikmen.dto.request.RegisterRequestDto;
import com.ertikmen.dto.response.RegisterResponseDto;
import com.ertikmen.exception.AuthManagerException;
import com.ertikmen.exception.ErrorType;
import com.ertikmen.manager.IUserManager;
import com.ertikmen.mapper.IAuthMapper;
import com.ertikmen.rabbitmq.model.MailModel;
import com.ertikmen.rabbitmq.producer.ActivationProducer;
import com.ertikmen.rabbitmq.producer.MailProducer;
import com.ertikmen.rabbitmq.producer.RegisterProducer;
import com.ertikmen.repository.IAuthRepository;
import com.ertikmen.repository.entity.Auth;
import com.ertikmen.repository.enums.EStatus;
import com.ertikmen.utility.CodeGenerator;
import com.ertikmen.utility.JwtTokenManager;
import com.ertikmen.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;

    private final JwtTokenManager jwtTokenManager;

    private final IUserManager userManager;

    private final RegisterProducer registerProducer;
    private final ActivationProducer activationProducer;

    private final MailProducer mailProducer;

    public AuthService(IAuthRepository authRepository, JwtTokenManager jwtTokenManager, IUserManager userManager, RegisterProducer registerProducer, ActivationProducer activationProducer, MailProducer mailProducer) {
        super(authRepository);
        this.authRepository = authRepository;
        this.jwtTokenManager = jwtTokenManager;
        this.userManager = userManager;
        this.registerProducer = registerProducer;
        this.activationProducer = activationProducer;
        this.mailProducer = mailProducer;
    }


    @Transactional
    public RegisterResponseDto register(RegisterRequestDto dto){
        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);
        auth.setActivationCode(CodeGenerator.generateCode());
        if (authRepository.existsByUsername(dto.getUsername())){
            throw new AuthManagerException(ErrorType.USERNAME_ALREADY_EXIST);
        }
        save(auth);

        //metot 2 microservice arası haberleşmek için

        userManager.save(IAuthMapper.INSTANCE.toUserSaveRequestDto(auth));


        RegisterResponseDto responseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);
        String token=jwtTokenManager.createToken(auth.getId())
                .orElseThrow(()->new AuthManagerException(ErrorType.INVALID_TOKEN));

        responseDto.setToken(token);

        return responseDto;
    }
    public String login(LoginRequestDto dto){
        Optional<Auth> optionalAuth = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(optionalAuth.isEmpty()){
            throw new AuthManagerException(ErrorType.LOGIN_ERROR);
        }
        if(!optionalAuth.get().getStatus().equals(EStatus.ACTIVE)){
            throw new AuthManagerException(ErrorType.ACCOUNT_NOT_ACTIVE);
        }

        return jwtTokenManager.createToken(optionalAuth.get().getId(),optionalAuth.get().getRole())
                .orElseThrow(()-> new AuthManagerException(ErrorType.TOKEN_NOT_CREATED));
    }



    @Transactional
    public String activateStatus(ActivateRequestDto dto){
        Optional<Long> id=jwtTokenManager.getIdFromToken(dto.getToken());
        if (id.isEmpty()){
            throw  new AuthManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Auth> optionalAuth = findById(id.get());
        if(optionalAuth.isEmpty()){
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        if(optionalAuth.get().getStatus().equals(EStatus.ACTIVE)){
            throw new AuthManagerException(ErrorType.ALREADY_ACTIVE);
        }
        if(dto.getActivationCode().equals(optionalAuth.get().getActivationCode())){
            optionalAuth.get().setStatus(EStatus.ACTIVE);
            update(optionalAuth.get());
//            userManager.activateStatus(dto.getToken()); // open feign ile haberleşme****

            activationProducer.activateStatus(dto.getToken()); // rabbitmq ile haberleşme***



            return "Hesabınız aktive edilmiştir";
        }else {
            throw new AuthManagerException(ErrorType.INVALID_CODE);
        }
    }

    public String updateAuth(AuthUpdateRequestDto dto){
        Optional<Auth> auth=findById(dto.getId());
        if (auth.isEmpty())
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        auth.get().setEmail(dto.getEmail());
        auth.get().setUsername(dto.getUsername());
        update(auth.get());
        return "Güncelleme başarılı";
    }
    @Transactional
    public RegisterResponseDto registerWithRabbitMq(RegisterRequestDto dto){
        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);
        auth.setActivationCode(CodeGenerator.generateCode());
        if (authRepository.existsByUsername(dto.getUsername())){
            throw new AuthManagerException(ErrorType.USERNAME_ALREADY_EXIST);
        }
        save(auth);

        //rabbitmq ile haberleştireceğiz..

        registerProducer.sendNewUser(IAuthMapper.INSTANCE.toRegisterModel(auth));

        //register tokun oluşturmak için yapılan işlem..

        RegisterResponseDto responseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);

        String token=jwtTokenManager.createToken(auth.getId())
                .orElseThrow(()->new AuthManagerException(ErrorType.INVALID_TOKEN));

        responseDto.setToken(token);

        // mail atma işlemini mail servis ile haberleştirilecek***

            //Kendi Yaptığım...
//        MailModel mailModel=new MailModel();
//        mailModel.setUsername(auth.getUsername());
//        mailModel.setEmail(auth.getEmail());
//        mailModel.setActivationCode(auth.getActivationCode());
//        mailModel.setToken(token);
//        mailProducer.sendMail(mailModel);

            //2. yol
//        mailProducer.sendMail(MailModel.builder()
//                        .activationCode(auth.getActivationCode())
//                        .username(auth.getUsername())
//                        .email(auth.getEmail())
//                        .token(token)
//                        .build());

        MailModel mailModel=IAuthMapper.INSTANCE.toMailModel(auth);
        mailModel.setToken(token);

        mailProducer.sendMail(mailModel); // kuyruğa veri yükledi...

        return responseDto;
    }


    public String deleteAuth(Long id) {

        Optional<Auth> auth=findById(id);
        if (auth.isEmpty())
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        if(auth.get().getStatus().equals(EStatus.DELETED))
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND,"Hesap Zaten Silinmiş..");

        auth.get().setStatus(EStatus.DELETED);
        update(auth.get());

        userManager.deleteById(id);

        return id + "id'li kullanıcı başarıyla silindi.";
    }
}
