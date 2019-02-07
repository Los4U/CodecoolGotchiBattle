package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    private static Battle instance = null;
    private boolean finished;
    private List<Gotchi> gotchiPool;

    private Battle() {
        gotchiPool = new ArrayList<>();
        finished = false;
    }

    public static Battle getInstance() {
        if (null == instance) instance = new Battle();

        return instance;
    }

    public void createTwoGotchies(String name, Type type, int attack, int speed, int defense){
        createSingleGotchi(name, type, attack, speed, defense);
        createGotchiByPC();
    }

    private void createSingleGotchi(String name, Type type, int attack, int speed, int defense) {
        gotchiPool.add(new Gotchi(name, type, attack, speed, defense));
    }

    private void createGotchiByPC(){
        String name = "Player2 Gotchi";
        Type type = Type.PAPER;
        int attack = 50;
        int speed = 80;
        int defense = 70;

        gotchiPool.add(new Gotchi(name, type, attack, speed, defense));
    }

    public Gotchi getGotchiByIndex(int index) {
        return gotchiPool.get(index);
    }
}
