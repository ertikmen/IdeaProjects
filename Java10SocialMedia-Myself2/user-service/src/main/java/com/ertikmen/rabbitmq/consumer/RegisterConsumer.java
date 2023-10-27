package com.ertikmen.rabbitmq.consumer;

import com.ertikmen.rabbitmq.model.RegisterModel;
import com.ertikmen.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j //Loglama ifadesi
public class RegisterConsumer {


    private final UserService userService;

    @RabbitListener(queues = ("${rabbitmq.register-queue}"))
    public void newUserCreate(RegisterModel model){

        log.info("User {}",model);
        userService.createNewUserWithRabbitmq(model);

    }


}
