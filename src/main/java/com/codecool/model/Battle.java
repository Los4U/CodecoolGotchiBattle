package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    private Gotchi player1;
    private Gotchi player2;

    public void initPlayer1(String name, Type type, int attack, int speed, int defense){
        player1 = new Gotchi(name, type, attack, speed, defense);
    }

    public void initPlayer2(String name, Type type, int attack, int speed, int defense){
        player2 = new Gotchi(name, type, attack, speed, defense);
    }

    public void createGotchiByPC(){
        initPlayer2("Computer's Gotchi", Type.ROCK, 50, 50, 50);
    }

    public Gotchi getPlayer1() {
        return player1;
    }

    public Gotchi getPlayer2() {
        return player2;
    }
}
