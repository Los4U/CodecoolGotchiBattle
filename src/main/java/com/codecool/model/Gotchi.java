package com.codecool.model;

public class Gotchi {
    private String name;
    private Type type;
    private int attack;
    private int speed;
    private int defence;

    public Gotchi(String name, Type type, int attack, int speed, int defence) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.speed = speed;
        this.defence = defence;
    }
}
