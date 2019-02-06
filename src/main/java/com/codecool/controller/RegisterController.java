package com.codecool.controller;

import com.codecool.model.Game;
import com.codecool.model.Gotchi;
import com.codecool.model.Type;
import com.codecool.model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Parent mainRoot;

    @FXML
    private Button registerButton;

    @FXML
    private TextField userNameTf;

    @FXML
    private TextField gotchiNameTf;

    @FXML
    private TextField attackAmount;

    @FXML
    private TextField defenseAmount;

    @FXML
    private TextField speedAmount;

    @FXML
    private ChoiceBox typeCB;

    @FXML
    public void registerPlayer(ActionEvent event) {
        Game game = Game.getInstance();
        String userName = userNameTf.getText();
        String gotchiName = gotchiNameTf.getText();
        Type gotchiType = (Type) typeCB.getValue();
        int attack = Integer.valueOf(attackAmount.getText());
        int defense = Integer.valueOf(defenseAmount.getText());
        int speed = Integer.valueOf(speedAmount.getText());
        Gotchi gotchi = game.createGotchi(gotchiName, gotchiType, attack, speed, defense);
        game.createPlayer(userName, gotchi);

        if (game.isReady()) mainRoot = new Pane();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeCB.getItems().add(Type.PAPER);
        typeCB.getItems().add(Type.ROCK);
        typeCB.getItems().add(Type.SCISSORS);
        typeCB.setValue(Type.PAPER);
    }
}
