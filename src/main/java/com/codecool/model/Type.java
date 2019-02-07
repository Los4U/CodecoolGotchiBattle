package com.codecool.model;

public enum Type {
    PAPER("paper.png"),
    SCISSORS("scissors.png"),
    ROCK("rock.png");

    private String fileName;

    Type(String fileName) {
        this.fileName = fileName;
    }

    public Type getWeaker() {
        if (this == Type.PAPER) return Type.ROCK;
        else if (this == Type.ROCK) return Type.SCISSORS;
        else return Type.PAPER;
    }

    public Type getStronger() {
        if (this == Type.PAPER) return Type.SCISSORS;
        else if (this == Type.SCISSORS) return Type.ROCK;
        else return Type.PAPER;
    }

    public String getValue() {
        return fileName;
    }
}
