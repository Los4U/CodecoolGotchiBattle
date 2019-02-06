package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Game instance = null;
    private List<User> players;

    private Game() {
        players = new ArrayList<>();
    }

    public static Game getInstance() {
        if (instance == null) instance = new Game();

        return instance;
    }

    public void createPlayer(String name, Gotchi gotchi) {
        User player = new User(name, gotchi);

        players.add(player);
    }

    public Gotchi createGotchi(String name, Type type, int attack, int speed, int defence) {
        return new Gotchi(name, type, attack, speed, defence);
    }

    public boolean isReady() {
        return players.size() > 1;
    }
}
