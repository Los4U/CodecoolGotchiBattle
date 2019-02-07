package com.codecool.model;

public class Gotchi {
    private int id;
    private static int counter = 0;
    private String name;
    private Type type;
    private int attack;
    private int speed;
    private int defence;

//    public Gotchi() {
//        id = ++counter;
//        this.name = "Gotchi " + id;
//        this.type = Type.PAPER;
//        this.attack = 80;
//        this.speed = 50;
//        this.defence = 100;
//    }

    public Gotchi(String name, Type type, int attack, int speed, int defence) {
        id = ++counter;
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.speed = speed;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
