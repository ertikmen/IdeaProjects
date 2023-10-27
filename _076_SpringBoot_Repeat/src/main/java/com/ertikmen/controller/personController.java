package com.ertikmen.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class personController {

    @GetMapping
    public String getHello(){
        return "Merhaba Spring Boot";
    }

    @GetMapping("/personel")
    public String getPersonelInfo(){
        return "Personel Bilgisi";
    }

}
