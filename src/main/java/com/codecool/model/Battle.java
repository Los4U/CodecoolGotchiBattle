package com.codecool.model;

import java.util.ArrayList;

public class Battle {

    private Gotchi player1;
    private Gotchi player2;
    private int gotchi1health = Config.MAX_HEALTH ;
    private int gotchi2health = Config.MAX_HEALTH ;
    private int gotchi1stamina = Config.MAX_STAMINA;
    private int gotchi2stamina = Config.MAX_STAMINA;


    public void initPlayer1(String name, Type type, int attack, int speed, int defense){
        player1 = new Gotchi(name, type, attack, speed, defense);
    }

    public void initPlayer2(String name, Type type, int attack, int speed, int defense){
        player2 = new Gotchi(name, type, attack, speed, defense);
    }

    public void createGotchiByPC(){
        initPlayer2("Computer's Gotchi", Type.ROCK, 70, 70, 60);
    }

    public ArrayList<String> carryAction(Action playerOneAcction){
        ArrayList<String> info = new ArrayList<>(5);

        for (int i = 0; i < 5; i++) {
            info.add("test");
        }

        switch(playerOneAcction) {
            case PRIMARY:
                info.set(Config.PLAYER_1_STATUS, "Player: " + player1.getName() + " did PRIMARY ATTACK");
                gotchi1stamina -= 20;
                info.set(Config.PLAYER_1_STP, String.valueOf(gotchi1stamina));
                break;

            case SECONDARY:
                info.set(Config.PLAYER_1_STATUS, "Player: " + player1.getName() + " did SECONDARY ATTACK");
                gotchi1stamina -= 20;
                info.set(Config.PLAYER_1_STP, String.valueOf(gotchi1stamina));
                break;

            case DEFENSE:
                info.set(Config.PLAYER_1_STATUS, "Player: " + player1.getName() + " did DEFENSE");
                gotchi1stamina -= 10;
                info.set(Config.PLAYER_1_STP, String.valueOf(gotchi1stamina));
                break;

            case EVADE:
                info.set(Config.PLAYER_1_STATUS, "Player: " + player1.getName() + " did EVADE");
                gotchi1stamina -= 5;
                info.set(Config.PLAYER_1_STP, String.valueOf(gotchi1stamina));
                break;
        }
        return info;
    }



    public Gotchi getPlayer1() {
        return player1;
    }

    public Gotchi getPlayer2() {
        return player2;
    }
}
