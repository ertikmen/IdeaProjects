package com.ertikmen.iocconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(IocConfig.class);

       String myName=context.getBean("name",String.class);
       Integer toplam=context.getBean("toplam",Integer.class);
        System.out.println(myName);
        System.out.println(toplam);

        IRunable game=context.getBean("getMario",IRunable.class);
        System.out.println(game);
        IRunable game2=context.getBean(IRunable.class);
        System.out.println(game2);

        GameRunner gameRunner=context.getBean(GameRunner.class);
        GameRunner gameRunner2=context.getBean("gameRunner",GameRunner.class);

        gameRunner.run();
        gameRunner2.run();


    }
}
