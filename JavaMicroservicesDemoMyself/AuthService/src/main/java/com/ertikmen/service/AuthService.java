package com.ertikmen.service;


import com.ertikmen.dto.request.DoLoginRequestDto;
import com.ertikmen.repository.IAuthRepository;
import com.ertikmen.repository.entity.Auth;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        this.authRepository = authRepository;
    }


    public String doLogin(DoLoginRequestDto dto) {

        Optional<Auth> auth= authRepository.findOptionalByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if (auth.isEmpty()){
            throw new RuntimeException("Kullanıcı Bulunamadı.");
        }
        return auth.get().toString();

    }
}
