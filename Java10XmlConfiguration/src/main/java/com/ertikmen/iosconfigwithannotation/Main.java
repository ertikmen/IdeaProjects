package com.ertikmen.iosconfigwithannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(IocConfig.class);

        GameRunner gameRunner=context.getBean(GameRunner.class);

        gameRunner.run();


    }
}
