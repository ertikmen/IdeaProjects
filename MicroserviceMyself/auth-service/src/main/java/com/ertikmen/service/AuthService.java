package com.ertikmen.service;


import com.ertikmen.dto.request.RegisterRequestDto;
import com.ertikmen.dto.response.RegisterResponseDto;
import com.ertikmen.mapper.IAuthMapper;
import com.ertikmen.repository.IAuthRepository;
import com.ertikmen.repository.entity.Auth;
import com.ertikmen.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class AuthService  extends ServiceManager<Auth,Long> {

    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }


    @Transactional
    public RegisterResponseDto register(RegisterRequestDto dto) {

        //1. Yol
//        Auth auth= new Auth();
//        auth.setUsername(dto.getUsername());
//        auth.setId(dto.getId());

        // 2. yol Build
//        Auth auth=Auth.builder()
//                .id(dto.getId())
//                .username(dto.getUsername())
//                .build();

        // 3. yol kullanacağımız Map

        Auth auth= IAuthMapper.INSTANCE.toAuth(dto);
        save(auth);

        RegisterResponseDto responseDto=IAuthMapper.INSTANCE.toRegisterResponseDto(auth);



        return responseDto;


    }
}
