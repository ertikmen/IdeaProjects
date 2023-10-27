package com.ertikmen.annotation.qualifier;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("contra")
public class ContraQualifier implements IRunableQualifier {

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
