package com.codecool.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeTest {
    static Type testingType;

    @Test
    void getWeaker() {
        assertEquals(Type.SCISSORS, Type.ROCK.getWeaker());
        assertEquals(Type.PAPER, Type.SCISSORS.getWeaker());
        assertEquals(Type.ROCK, Type.PAPER.getWeaker());
    }

    @Test
    void getStronger() {
        assertEquals(Type.PAPER, Type.ROCK.getStronger());
        assertEquals(Type.SCISSORS, Type.PAPER.getStronger());
        assertEquals(Type.ROCK, Type.SCISSORS.getStronger());
    }
}
