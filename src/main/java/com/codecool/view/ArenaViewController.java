package com.codecool.view;

import com.codecool.controller.BattleController;
import com.codecool.model.Config;
import com.codecool.model.Gotchi;
import com.codecool.model.Type;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArenaViewController implements Initializable {

    // Player 1 state elements
    @FXML
    private Label player1NameTF;
    @FXML
    private ImageView player1Image;
    @FXML
    private TextField player1HP;
    @FXML
    private TextField player1STP;


    // Player 2 state elements
    @FXML
    private Label player2NameTF;
    @FXML
    private ImageView player2Image;
    @FXML
    private TextField player2HP;


    //Other elements
    @FXML
    private TextField messagePlayer1;
    @FXML
    private TextField messagePlayer2;

    @FXML
    private Button primaryAttackButton;

    @FXML
    private Button secondaryAttackButton;

    @FXML
    private Button defenseButton;

    @FXML
    private Button evadeButton;

    BattleController battleController;
    ArrayList<String> battleStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        primaryAttackButton.setMinWidth(150);
        secondaryAttackButton.setMinWidth(150);
        defenseButton.setMinWidth(150);
        evadeButton.setMinWidth(150);

        battleController = BattleController.getInstance();
        Gotchi firstGotchi = battleController.getFirstPlayer();
        Gotchi secondGotchi = battleController.getSecondPlayer();

        player1HP.setText(String.valueOf(Config.MAX_HEALTH));
        player1STP.setText(String.valueOf(Config.MAX_STAMINA));


        player1NameTF.setText(firstGotchi.getName());
        player2NameTF.setText(secondGotchi.getName());

        loadPlayersImages(firstGotchi.getType(), secondGotchi.getType());
    }

    private void loadPlayersImages(Type player1Type, Type player2Type) {
        String player1ImagePath = String.valueOf(this.getClass().getResource(Config.IMAGES_PATH + player1Type.getValue()));
        String player2ImagePath = String.valueOf(this.getClass().getResource(Config.IMAGES_PATH + player2Type.getValue()));

        player1Image.setImage(new Image(String.valueOf(player1ImagePath)));
        player2Image.setImage(new Image(String.valueOf(player2ImagePath)));
    }

    public void action(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
        String action = button.getText();

        //Action actionEnum = Action.valueOf(action.toUpperCase());
        //System.out.println("enum" + actionEnum);

        battleStatus = battleController.battleControllerAction(action);

        messagePlayer1.setText(battleStatus.get(Config.PLAYER_1_STATUS));
        messagePlayer2.setText(battleStatus.get(Config.PLAYER_2_STATUS));

        player1HP.setText(String.valueOf(battleStatus.get(Config.PLAYER_1_STP)));
        player1STP.setText(String.valueOf(battleStatus.get(Config.PLAYER_1_STP)));



    }
}

