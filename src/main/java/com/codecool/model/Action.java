package com.codecool.model;

public enum Action {
    PRIMARY(1.0, 20),
    SECONDARY( 0.75, 20),
    DEFENSE(0, 10),
    EVADE (0, 5);

    private double attackModifier;
    private int staminaSpend;

    Action(double attackModifier, int staminaSpend) {
        this.attackModifier = attackModifier;
        this.staminaSpend = staminaSpend;
    }

    public double getAttackModifier() {
        return attackModifier;
    }

    public int getStaminaSpend() {
        return staminaSpend;
    }
}
