package com.codecool.controller;

import com.codecool.model.Battle;
import com.codecool.model.Gotchi;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {
    @FXML
    private Label player1NameTF;

    @FXML
    private Label player2NameTF;

    @FXML
    private Button primaryAttackButton;

    @FXML
    private Button secondaryAttackButton;

    @FXML
    private Button defenseButton;

    @FXML
    private Button evadeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Battle battle = Battle.getInstance();
        Gotchi firstGotchi = battle.getGotchiByIndex(0);
        Gotchi secondGotchi = battle.getGotchiByIndex(1);

        player1NameTF.setText(firstGotchi.getName());
        player2NameTF.setText(secondGotchi.getName());
    }
}
