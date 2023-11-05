package com.example.movietheatreproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
//    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("KioskFXMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("San Diego Movie Theatre Company");
        stage.setScene(scene);
        stage.show();
//        primaryStage = stage;

    }

    public static void main(String[] args) {
        launch();
    }
}