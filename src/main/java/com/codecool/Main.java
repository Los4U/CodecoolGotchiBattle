package com.codecool;

import com.codecool.model.Config;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Config.MAIN_SCREEN_PATH));
        StackPane mainPane = fxmlLoader.load();
        Scene mainScene = new Scene(mainPane);
        primaryStage.setScene(mainScene);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Gotchi Battle");
        primaryStage.show();
    }
}
