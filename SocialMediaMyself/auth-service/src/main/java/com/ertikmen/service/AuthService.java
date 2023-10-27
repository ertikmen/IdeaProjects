package com.ertikmen.service;

import com.ertikmen.dto.request.ActiveRequestDto;
import com.ertikmen.dto.request.LoginRequestDto;
import com.ertikmen.dto.request.RegisterRequestDto;
import com.ertikmen.dto.response.RegisterResponseDto;
import com.ertikmen.exception.AuthManagerException;
import com.ertikmen.exception.ErrorType;
import com.ertikmen.mapper.IAuthMapper;
import com.ertikmen.repository.IAuthRepository;
import com.ertikmen.repository.entity.Auth;
import com.ertikmen.repository.enums.EStatus;
import com.ertikmen.utility.CodeGenerator;
import com.ertikmen.utility.ServiceManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;


    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }

    public RegisterResponseDto register(RegisterRequestDto dto) {

        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);
        auth.setActivationCode(CodeGenerator.generateCode());
        save(auth);

        RegisterResponseDto responseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);

        return responseDto;
    }

    public Boolean login(LoginRequestDto dto) {

        Optional<Auth> optionalAuth = authRepository.findOptinalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (optionalAuth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        if (!optionalAuth.get().getStatus().equals(EStatus.ACTIVE)){
            throw new AuthManagerException(ErrorType.ACCOUNT_NOT_ACTIVE);
        }
        return true;

    }

    public Boolean activateStatus(ActiveRequestDto dto){

          // Optional<Auth> optionalAuth=authRepository.findById(dto.getId());

        Optional<Auth> optionalAuth=findById(dto.getId());

        if (optionalAuth.isEmpty()){
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        if (optionalAuth.get().getStatus().equals(EStatus.ACTIVE)){
            throw new AuthManagerException(ErrorType.ALREADY_ACTIVE);
        }
        if (dto.getActivationCode().equals(optionalAuth.get().getActivationCode())){
            optionalAuth.get().setStatus(EStatus.ACTIVE);
            update(optionalAuth.get());
            return true;
        }else {
            throw new AuthManagerException(ErrorType.INVALID_CODE);
        }

    }














}
