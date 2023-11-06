package com.example.movietheatreproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieFutureController {
    @FXML private AnchorPane mainAnchor;
    @FXML private Label titleLabel2;
    @FXML private Button quitButton;
    @FXML private Button backButton;
    @FXML private Button checkOutButton;
    @FXML private DatePicker dateSelector;
    @FXML private Button dateButton;
    @FXML public void cartMenu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KioskFXCheckOut.fxml"));
            Parent root = fxmlLoader.load();
            mainAnchor.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML public void returnToMainMenu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KioskFXMain.fxml"));
            Parent root = fxmlLoader.load();
            mainAnchor.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML public void quitPressed(ActionEvent event) {
        ((Stage) quitButton.getScene().getWindow()).close();
    }
}
