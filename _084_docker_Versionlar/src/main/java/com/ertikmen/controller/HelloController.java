package com.ertikmen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// http://localhost:8080/api/v1

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    // http://localhost:8080/api/v1/hello

    @GetMapping("/hello")
    public String hello() {
        return "hello docker";
    }

    @GetMapping("/metod2")
    public String metod2() {
        return "hello docker metod2";
    }

    @GetMapping("/metod3")
    public String metod3() {
        return "hello docker metod3";
    }
}
