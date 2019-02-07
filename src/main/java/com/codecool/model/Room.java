package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<User> players;

    public Room() {
        players = new ArrayList<>();
    }

    public void createPlayer(String name, Gotchi gotchi) {
        User player = new User(name, gotchi);

        players.add(player);
    }

    public Gotchi createGotchi(String name, Type type, int attack, int speed, int defence) {
        return new Gotchi(name, type, attack, speed, defence);
    }

    public boolean canCreateGotchi(String name, Type type, int attack, int speed, int defence) {
        return true;
    }

    public boolean isFull() {
        return players.size() > 1;
    }
}
