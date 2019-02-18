package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class Battle {

    private Gotchi player1;
    private Gotchi player2;
    private int gotchi1health = Config.MAX_HEALTH ;
    private int gotchi2health = Config.MAX_HEALTH ;
    private int gotchi1stamina = Config.MAX_STAMINA;
    private int gotchi2stamina = Config.MAX_STAMINA;;


    public void initPlayer1(String name, Type type, int attack, int speed, int defense){
        player1 = new Gotchi(name, type, attack, speed, defense);
    }

    public void initPlayer2(String name, Type type, int attack, int speed, int defense){
        player2 = new Gotchi(name, type, attack, speed, defense);
    }

    public void createGotchiByPC(){
        initPlayer2("Computer's Gotchi", Type.ROCK, 50, 50, 50);
    }

    public ArrayList<String> carryAction(String playerOneAcction){
        ArrayList<String> returnMessage = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            returnMessage.add("test");
        }



        if(playerOneAcction.equals("Primary")){
            returnMessage.set(Config.PLAYER_1_STATUS, "Player: " + player1.getName() + " did PRIMARY ATTACK");
            gotchi1stamina -= 20;
            returnMessage.set(Config.PLAYER_1_STP, String.valueOf(gotchi1stamina));
        }else if(playerOneAcction.equals("Secondary")){
            returnMessage.set(Config.PLAYER_1_STATUS, "Player: " + player1.getName() + " did SECONDARY ATTACK");
            gotchi1stamina -= 20;
            returnMessage.set(Config.PLAYER_1_STP, String.valueOf(gotchi1stamina));

        }else if(playerOneAcction.equals("Defense")){
            returnMessage.set(Config.PLAYER_1_STATUS, "Player: " + player1.getName() + " did DEFENSE");
            gotchi1stamina -= 10;
            returnMessage.set(Config.PLAYER_1_STP, String.valueOf(gotchi1stamina));

        }else if (playerOneAcction.equals("Evade")){
            returnMessage.set(Config.PLAYER_1_STATUS, "Player: " + player1.getName() + " did EVADE");
            gotchi1stamina -= 5;
            returnMessage.set(Config.PLAYER_1_STP, String.valueOf(gotchi1stamina));
        }

        for(String elem: returnMessage){
            System.out.println(elem);
        }

        return returnMessage;
    }



    public Gotchi getPlayer1() {
        return player1;
    }

    public Gotchi getPlayer2() {
        return player2;
    }
}
