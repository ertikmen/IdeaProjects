package com.ertikmen.annotation.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mario")
public class MarioQualifier implements IRunableQualifier {

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
