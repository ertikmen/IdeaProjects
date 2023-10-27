package com.ertikmen.controller;


import com.ertikmen.repository.entity.Auth;
import com.ertikmen.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class AdminController {

    private final AuthService authService;

    @GetMapping("/find_all")
    public ResponseEntity<List<Auth>> findAll(){

        return ResponseEntity.ok(authService.findAll());
    }


}
