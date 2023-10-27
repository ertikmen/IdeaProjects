package com.ertikmen._076_SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PersonController {


    @GetMapping
    public String getHello(){

        return "Merhaba String Boot";
    }

    @GetMapping("/personel")
    public String getPersonelInfo(){

        return "Personel Bilgisi eklendi";
    }

}
