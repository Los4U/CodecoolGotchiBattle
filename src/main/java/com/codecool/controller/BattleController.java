package com.codecool.controller;

import com.codecool.model.Action;
import com.codecool.model.Battle;
import com.codecool.model.Gotchi;
import com.codecool.model.Type;

import java.util.ArrayList;

public class BattleController {
    private Battle battle;
    private static BattleController instance;

    private BattleController() {
        battle = new Battle();
    }

    public static void reset() {
        instance = null;
    }

    public static BattleController getInstance() {
        if (null == instance) instance = new BattleController();

        return instance;
    }

    public void createGotchies(String player1Name, Type type, int attack, int speed, int defense) {
        battle.initPlayer1(player1Name, type, attack, speed, defense);
        battle.createGotchiByPC();
    }

    public ArrayList<String> battleControllerAction(Action actionType){
        return battle.carryAction(actionType);
    }

    public Gotchi getFirstPlayer() {
        return battle.getPlayer1();
    }

    public Gotchi getSecondPlayer() {
        return battle.getPlayer2();
    }


}
