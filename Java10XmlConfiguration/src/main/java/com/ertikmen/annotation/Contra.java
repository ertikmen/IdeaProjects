package com.ertikmen.annotation;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Contra implements IRunable {

    public void up(){
        System.out.println("Yukarı");
    }

    public void down(){
        System.out.println("Eğil");
    }

    public void left(){
        System.out.println("Geri git");
    }

    public void right(){
        System.out.println("Ateş et");
    }
}
