package com.ertikmen.controller;



import com.ertikmen.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.ertikmen.constant.EndPoints.*;


@RestController
@RequestMapping(MAIL)
@RequiredArgsConstructor
public class Mailcontroller {

    private final MailService mailService;

}
