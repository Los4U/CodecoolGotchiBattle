package com.codecool.controller;

import com.codecool.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private TextField player1Input;

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
        String player1Name = player1Input.getText();
        Type type = (Type) typeCB.getValue();
        int attack = Integer.valueOf(attackAmount.getText());
        int defense = Integer.valueOf(defenseAmount.getText());
        int speed = Integer.valueOf(speedAmount.getText());

        BattleController.getInstance().createGotchies(player1Name, type, attack, speed, defense);
        this.startBattle();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeCB.getItems().add(Type.PAPER);
        typeCB.getItems().add(Type.ROCK);
        typeCB.getItems().add(Type.SCISSORS);
        typeCB.setValue(Type.PAPER);

    }

    @FXML
    public void startBattle() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(Config.BATTLE_PATH));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainController.setScreen(pane);
    }
}
