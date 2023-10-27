package com.ertikmen;

import com.ertikmen.service.MessageProccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

        log.info("Uygulama Başladı");

        ApplicationContext applicationContext=SpringApplication.run(Application.class,args);
        MessageProccessor messageProccessor=applicationContext.getBean(MessageProccessor.class);
        messageProccessor.processingMsg("Selamlar nasılsın?");

        log.info("Uygulama Bitti");

    }

}
