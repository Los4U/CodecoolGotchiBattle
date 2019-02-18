package com.codecool.view;

import com.codecool.controller.BattleController;
import com.codecool.controller.MainController;
import com.codecool.model.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterViewController implements Initializable {
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private TextField player1Input;

    @FXML
    private TextField attackPointsTF;

    @FXML
    private TextField defensePointsTF;

    @FXML
    private TextField speedPointsTF;

    @FXML
    private ChoiceBox typeCB;

    @FXML
    private ImageView typeImageView;

    @FXML
    private TextField statPointsTF;

    @FXML
    private Slider attackSlider;

    @FXML
    private Slider speedSlider;

    @FXML
    private Slider defenseSlider;

    @FXML
    public void registerPlayer(ActionEvent event) {
        String player1Name = player1Input.getText();
        Type type = (Type) typeCB.getValue();
        int attack = Integer.valueOf(attackPointsTF.getText());
        int defense = Integer.valueOf(defensePointsTF.getText());
        int speed = Integer.valueOf(speedPointsTF.getText());

        BattleController.getInstance().createGotchies(player1Name, type, attack, speed, defense);
        this.startBattle();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeCB.getItems().add(Type.PAPER);
        typeCB.getItems().add(Type.ROCK);
        typeCB.getItems().add(Type.SCISSORS);
        typeCB.setValue(Type.PAPER);
        updateTypeImage((Type) typeCB.getValue());
        typeCB.getSelectionModel().selectedItemProperty().addListener((e) -> {
            ObservableValue ob = (ObservableValue) e; // Convert to observablevalue to get value otherwise its impossible
            Type type = (Type) ob.getValue(); // convert received value to Type to update the image
            updateTypeImage(type);
        });

        statPointsTF.setText(String.valueOf(Config.STATISTICS_POINTS));

        attackSlider.valueProperty().addListener(new SliderChangeListener(attackPointsTF, attackSlider));
        speedSlider.valueProperty().addListener(new SliderChangeListener(speedPointsTF, speedSlider));
        defenseSlider.valueProperty().addListener(new SliderChangeListener(defensePointsTF, defenseSlider));

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

    @FXML
    public void updateTypeImage(Type type) {
        String imagePath = String.valueOf(this.getClass().getResource(Config.IMAGES_PATH + type.getValue()));
        typeImageView.setImage(new Image(imagePath));
    }

    @FXML
    public void updateStatPointsLeft() {
        int attack, speed, defense;
        try {
            attack = Integer.valueOf(attackPointsTF.getText());
            speed = Integer.valueOf(speedPointsTF.getText());
            defense = Integer.valueOf(defensePointsTF.getText());

            statPointsTF.setText(String.valueOf(Config.STATISTICS_POINTS - (attack + speed + defense)));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }

    }

    class SliderChangeListener implements ChangeListener {
        private Slider currentSlider;
        private TextField currentSliderTF;
        private int currentValue = 0;

        public SliderChangeListener(TextField currentSliderTF, Slider slider) {
            this.currentSliderTF = currentSliderTF;
            currentSlider = slider;
        }

        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            currentValue = (int) ((double) newValue);
            currentSliderTF.setText(String.valueOf(currentValue));
            updateStatPointsLeft();
        }
    }
}
