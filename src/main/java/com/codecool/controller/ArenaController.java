package com.codecool.controller;

import com.codecool.model.Config;
import com.codecool.model.Gotchi;
import com.codecool.model.Type;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {

    // Player 1 state elements
    @FXML
    private Label player1NameTF;

    @FXML
    private ImageView player1Image;

    @FXML
    private TextField player1HP;

    @FXML
    private TextField player1SP;


    // Player 2 state elements
    @FXML
    private Label player2NameTF;

    @FXML
    private ImageView player2Image;

    @FXML
    private TextField player2HP;

    @FXML
    private TextField player2SP;


    //Other elements
    @FXML
    private TextField messageTF;

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
