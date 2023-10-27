package com.ertikmen.service;


import com.ertikmen.rabbitmq.model.MailModel;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;


    public void sendMail(MailModel model) {

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("${java10_mail}");
        mailMessage.setTo(model.getEmail());
        mailMessage.setSubject("AKTIVASYON KODUNUZ....");
        mailMessage.setText("Merhaba "+model.getUsername()+"\n"+
                "token ===>> "+model.getToken()+"\n"+
                "Aktivasyon Kodonuz: "+model.getActivationCode()
                );

        javaMailSender.send(mailMessage);

        System.out.println("Mail gönderildi...");


    }




    //    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail(){
//
//        SimpleMailMessage mailMessage=new SimpleMailMessage();
//        mailMessage.setFrom("${java10_mail}");
//        mailMessage.setTo("engin.ertikmen120@gmail.com");
//        mailMessage.setSubject("AKTIVASYON KODUNUZ....");
//        mailMessage.setText("lk584585");
//        javaMailSender.send(mailMessage);
//
//    }
}
