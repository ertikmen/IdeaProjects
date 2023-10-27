package com.ertikmen.controller;


import com.ertikmen.dto.request.RegisterRequestDto;
import com.ertikmen.dto.response.RegisterResponseDto;
import com.ertikmen.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.ertikmen.constant.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {

    public final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto){

        return ResponseEntity.ok(authService.register(dto));

    }


}
