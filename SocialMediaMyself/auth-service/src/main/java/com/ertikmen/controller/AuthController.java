package com.ertikmen.controller;


import com.ertikmen.dto.request.ActiveRequestDto;
import com.ertikmen.dto.request.LoginRequestDto;
import com.ertikmen.dto.request.RegisterRequestDto;
import com.ertikmen.dto.response.RegisterResponseDto;
import com.ertikmen.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.ertikmen.constant.EndPoints.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH) // api/v1/auth
public class AuthController {

    private final AuthService authService;

    @PostMapping(REGISTER)   // api/v1/auth/register
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto){

        return ResponseEntity.ok(authService.register(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody ActiveRequestDto dto){
        return ResponseEntity.ok(authService.activateStatus(dto));
    }

}


