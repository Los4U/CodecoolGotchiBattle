package com.codecool.controller;

import com.codecool.model.Battle;
import com.codecool.model.Type;

public class BattleController {
    private Battle battle;

    public BattleController() {
        battle = Battle.getInstance();
    }

    public void createGotchies(String player1Name, Type type, int attack, int speed, int defense) {
        battle.createTwoGotchies(player1Name, type, attack, speed, defense);
    }
}
