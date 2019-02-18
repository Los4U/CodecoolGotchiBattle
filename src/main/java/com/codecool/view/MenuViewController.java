package com.codecool.view;

import com.codecool.controller.MainController;
import com.codecool.model.Config;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuViewController {

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private MainController mainController;

    @FXML
    private Button startButton;

    @FXML
    public void startRegister(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(Config.REGISTER_PATH));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RegisterViewController registerViewController = loader.getController();
        registerViewController.setMainController(mainController);
        mainController.setScreen(pane);
    }


}
