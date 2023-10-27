package com.ertikmen.iocconfig;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class Mario implements IRunable {

    public void up(){
        System.out.println("Zıpla");
    }

    public void down(){
        System.out.println("Bir deliğe gir");
    }

    public void left(){
        System.out.println("Geri Dön");
    }

    public void right(){
        System.out.println("Hızlan");
    }


}
