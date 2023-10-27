package com.ertikmen.annotation.qualifier;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("annotationContext.xml");


        GameRunnerQualifier gameRunner=context.getBean(GameRunnerQualifier.class);
        gameRunner.run();



    }
}
