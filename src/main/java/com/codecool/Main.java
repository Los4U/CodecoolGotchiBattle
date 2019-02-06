package com.codecool;

import com.codecool.model.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader =  new FXMLLoader( getClass().getResource("/fxml/register.fxml") );
        Game game = Game.getInstance();

        Parent content = fxmlLoader.load();
        Scene mainScene = new Scene(content);
        primaryStage.setScene(mainScene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
