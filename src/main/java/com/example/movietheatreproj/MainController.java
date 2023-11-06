package com.example.movietheatreproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class MainController {
    public static Stack<String> menuHistory = new Stack<>();

    @FXML private static AnchorPane mainAnchor;
    @FXML private Button quitButton;

    @FXML private void initialize() {
        User user = new User(0, "User");
        Kiosk kiosk = new Kiosk(0, "online", "lobby");
        Manager manager = new Manager(0, "Manager", "special_code");
    }
    @FXML public void setMainAnchor(AnchorPane mainAnchor) {
        MainController.mainAnchor = mainAnchor;
    }
    @FXML public void switchToFutureShowingsMenu(ActionEvent event) {
        loadFXML("KioskFXMovieFuture.fxml");
    }
    @FXML public void switchToTodaysShowingsMenu(ActionEvent event) {
        loadFXML("KioskFXMovieDaily.fxml");
    }
    @FXML public void switchToSodaMenu(ActionEvent event) {
        loadFXML("KioskFXSodaMenu.fxml");
    }
    @FXML public void switchToPopcornMenu(ActionEvent event) {
        loadFXML("KioskFXPopcorn.fxml");
    }
    @FXML public void switchToCheckOut(ActionEvent event) { loadFXML("KioskFXCheckOut.fxml"); }
    @FXML void quitPressed(ActionEvent event) {
        ((Stage) quitButton.getScene().getWindow()).close();
    }
    @FXML static void loadFXML(String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            mainAnchor.getChildren().setAll(root);
            menuHistory.push(fxmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
