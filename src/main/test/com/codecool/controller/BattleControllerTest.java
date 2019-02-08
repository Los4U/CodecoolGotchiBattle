package com.codecool.controller;

import com.codecool.model.Action;
import com.codecool.model.Config;
import com.codecool.model.Gotchi;
import com.codecool.model.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BattleControllerTest {
    BattleController bc;

    @BeforeEach
    void reset() {
        BattleController.reset();
        bc = BattleController.getInstance();
    }

    @Test
    void testCreateGotchies() {
        bc.createGotchies("player1", Type.PAPER, 20, 10, 15);
        Gotchi g1 = bc.getFirstPlayer();
        assertEquals("player1", g1.getName());
    }

    @Test
    void testBattle() {
        bc.createGotchies("player1", Type.PAPER, 20, 10, 15);
        List<String> result = bc.battleControllerAction(Action.PRIMARY);
        assertEquals("Player: player1 did PRIMARY ATTACK", result.get(Config.PLAYER_1_STATUS));
        Gotchi g2 = bc.getSecondPlayer();
        // examine g2
    }
}
