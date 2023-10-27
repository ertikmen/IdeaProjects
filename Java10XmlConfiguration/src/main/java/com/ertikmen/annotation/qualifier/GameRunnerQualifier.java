package com.ertikmen.annotation.qualifier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunnerQualifier {

    @Autowired
            @Qualifier("mario")
    IRunableQualifier game;

//    public GameRunnerQualifier(@Qualifier("mario") IRunableQualifier game) {
//        this.game = game;
//    }

    public void run(){

        System.out.println("Oyun çalışıyor==> "+game.getClass().getSimpleName());

        game.up();
        game.down();
        game.left();
        game.right();

    }

}
