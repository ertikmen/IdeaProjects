package com.ertikmen.service;

import com.ertikmen.dto.request.AuthUpdateRequestDto;
import com.ertikmen.dto.request.UserProfileUpdateRequestDto;
import com.ertikmen.dto.request.UserSaveRequestDto;
import com.ertikmen.dto.response.UserProfileFindAllResponseDto;
import com.ertikmen.dto.response.UserProfileUpdateResponseDto;
import com.ertikmen.exception.ErrorType;
import com.ertikmen.exception.UserManagerException;
import com.ertikmen.manager.IAuthManager;
import com.ertikmen.mapper.IUserMapper;
import com.ertikmen.rabbitmq.model.RegisterModel;
import com.ertikmen.rabbitmq.producer.RegisterElasticProducer;
import com.ertikmen.repository.IUserRepository;
import com.ertikmen.repository.entity.UserProfile;
import com.ertikmen.repository.enums.EStatus;
import com.ertikmen.utility.JwtTokenManager;
import com.ertikmen.utility.ServiceManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService extends ServiceManager<UserProfile, String> {

    private final IUserRepository userRepository;

    private final JwtTokenManager jwtTokenManager;
    private final IAuthManager authManager;

    private final CacheManager cacheManager;

    private final RegisterElasticProducer registerElasticProducer;

    public UserService(IUserRepository userRepository, JwtTokenManager jwtTokenManager, IAuthManager authManager, CacheManager cacheManager, RegisterElasticProducer registerElasticProducer) {
        super(userRepository);
        this.userRepository = userRepository;
        this.jwtTokenManager = jwtTokenManager;
        this.authManager = authManager;
        this.cacheManager = cacheManager;
        this.registerElasticProducer = registerElasticProducer;
    }

    public Boolean createNewUser(UserSaveRequestDto dto) {
        try {
            UserProfile userProfile= IUserMapper.INSTANCE.toUserProfile(dto);

            save(userProfile);
            return true;
        } catch (Exception e) {
            throw new UserManagerException((ErrorType.USER_NOT_CREATED));
        }
    }

    public String activateStatus(String token) {

        Optional<Long> authId=jwtTokenManager.getAuthIdFromToken(token);
        if (authId.isEmpty())
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        Optional<UserProfile> userProfile=userRepository.findByAuthId(authId.get());
        if (userProfile.isEmpty())
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        userProfile.get().setStatus(EStatus.ACTIVE);
        update(userProfile.get());
        return "Hesabınız Aktive Edilmiştir.";

    }

    @Transactional
    public String updateUserProfile(UserProfileUpdateRequestDto dto){

        Optional<Long> authId=jwtTokenManager.getAuthIdFromToken(dto.getToken());
        if (authId.isEmpty())
            throw new UserManagerException(ErrorType.INVALID_CODE);
        Optional<UserProfile> userProfile=userRepository.findByAuthId(authId.get());
        if (userProfile.isEmpty())
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        if (!userProfile.get().getEmail().equals(dto.getEmail()) || !userProfile.get().getUsername().equals(dto.getUsername())) {

            userProfile.get().setEmail(dto.getEmail());
            userProfile.get().setUsername(dto.getUsername());

            // auth service e istek atan bir metot yazılacak
            authManager.updateAuth(AuthUpdateRequestDto.builder().email(dto.getEmail()).username(dto.getUsername()).id(authId.get()).build());

        }
        userProfile.get().setAbout(dto.getAbout());
        userProfile.get().setPhone(dto.getPhone());
        userProfile.get().setAddress(dto.getAddress());
        userProfile.get().setName(dto.getName());
        userProfile.get().setSurName(dto.getSurName());
        userProfile.get().setAvatar(dto.getAvatar());

        update(userProfile.get());

//        cacheManager.getCache("find_by_username").evict(userProfile.get().getUsername());
        cacheManager.getCache("find_by_username").put(userProfile.get().getUsername(),userProfile.get());

        return "Güncelleme Başarılı...";


    }

    public Boolean createNewUserWithRabbitmq(RegisterModel model) {
        try {
            UserProfile userProfile= IUserMapper.INSTANCE.toUserProfile(model);
            save(userProfile);

            registerElasticProducer.sendNewUser(IUserMapper.INSTANCE.toRegisterElasticModel(userProfile));



            return true;
        } catch (Exception e) {
            throw new UserManagerException((ErrorType.USER_NOT_CREATED));
        }
    }

    @Cacheable(value= "find_by_username")
    public UserProfile findByUsername(String username){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Optional<UserProfile> userProfile=userRepository.findByUsername(username);
        if (userProfile.isEmpty())
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        return userProfile.get();

    }

    @Cacheable(value="find_by_status")
    public List<UserProfile> findByStatus(EStatus status){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<UserProfile> userList=userRepository.findByStatus(status);

        return userList;
    }

    @Cacheable(value="find_by_status2",key="#status.toUpperCase()") // cache lemeden önce büyük harf yapar tekrar tekrar cachelemez
    public List<UserProfile> findByStatus2(String status){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EStatus myStatus;
        try {
            myStatus=EStatus.valueOf(status.toUpperCase(Locale.ENGLISH)); // ****
        } catch (Exception e) {
            throw new UserManagerException(ErrorType.STATUS_NOT_FOUND);
        }
        return userRepository.findByStatus(myStatus);

    }


    public String deleteUserProfile(Long id) {

        Optional<UserProfile> userProfile=userRepository.findByAuthId(id);
        if (userProfile.isEmpty())
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);

        userProfile.get().setStatus(EStatus.DELETED);
        update(userProfile.get());

        cacheManager.getCache("find_by_username").evict(userProfile.get().getUsername());

        return userProfile.get().getId()+" id'li kullanıcı silinmiştir..";
    }


    public List<UserProfileFindAllResponseDto> findAllUserProfile() {

        List<UserProfile> userProfileList=findAll();
        return userProfileList.stream().map(x->IUserMapper.INSTANCE.toUserProfileFindAllResponseDto(x)).collect(Collectors.toList());
    }

    public String updateUserProfile2(UserProfileUpdateResponseDto dto) {



    }
}
