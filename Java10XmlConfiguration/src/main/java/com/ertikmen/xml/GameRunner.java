package com.ertikmen.xml;

public class GameRunner {

    IRunable game;
    String username;
    String password;

    public GameRunner(IRunable game) {
        this.game = game;
    }

    public void run(){

        System.out.println("Oyun çalışıyor==> "+game.getClass().getSimpleName());

        game.up();
        game.down();
        game.left();
        game.right();

    }

    public IRunable getGame() {
        return game;
    }

    public void setGame(IRunable game) {
        this.game = game;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
