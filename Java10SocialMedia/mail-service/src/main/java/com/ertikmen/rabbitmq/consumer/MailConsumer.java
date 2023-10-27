package com.ertikmen.rabbitmq.consumer;


import com.ertikmen.rabbitmq.model.MailModel;
import com.ertikmen.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailConsumer {

    private final MailService mailService;


    @RabbitListener(queues = ("${rabbitmq.mail-queue}"))
    public void sendEMail(MailModel model){

        mailService.sendMail(model);

    }
}
