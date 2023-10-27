package com.ertikmen.firstExample;

public class Contra implements IRunable{

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
