package com.ertikmen.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

//        IRunable game=context.getBean("mygame",IRunable.class);


        GameRunner gameRunner=context.getBean("gamerunner",GameRunner.class);
        gameRunner.run();

        System.out.println(gameRunner.getUsername());
        System.out.println(gameRunner.getPassword());


    }
}
