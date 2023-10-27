package com.ertikmen.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext2.xml");

        GameRunner gameRunner=context.getBean("gamerunner",GameRunner.class);
        gameRunner.run();

        System.out.println(gameRunner.getUsername());
        System.out.println(gameRunner.getPassword());


    }
}
