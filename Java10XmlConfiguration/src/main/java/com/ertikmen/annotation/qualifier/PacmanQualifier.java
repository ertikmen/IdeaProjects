package com.ertikmen.annotation.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pacman")
public class PacmanQualifier implements IRunableQualifier {


    public void up(){
        System.out.println("Yukarı");
    }

    public void down(){
        System.out.println("Aşağı");
    }

    public void left(){
        System.out.println("Sola");
    }

    public void right(){
        System.out.println("Sağa");
    }
}
