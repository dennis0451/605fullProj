package com.example.movietheatreproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieDailyController {
    private Ticket ticket = Ticket.getInstance();

    @FXML private AnchorPane mainAnchor;
    @FXML private Button quitButton;
    @FXML private TableView<Movie> movieShowtimesTable;
    @FXML private TableColumn<Movie, String> movieColumn;
    @FXML private TableColumn<Movie, String> showtimeColumn;

    @FXML public void initialize() {
        ObservableList<Movie> movieList = FXCollections.observableArrayList(
                new Movie("Movie1", "1:00 PM"),
                new Movie("Movie2", "1:30 PM"),
                new Movie("Movie3", "2:00 PM"),
                new Movie("Movie4", "2:30 PM")
        );

        movieColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        showtimeColumn.setCellValueFactory(new PropertyValueFactory<>("showtime"));

        movieShowtimesTable.setItems(movieList);
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

    @FXML public void selectMovie(ActionEvent event) {
        movieShowtimesTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                ticket.setMovieTitle(newSelection.getTitle());
                ticket.setShowTime(newSelection.getShowtime());

            }
        });
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KioskFXMovieSeats.fxml"));
            Parent root = fxmlLoader.load();
            mainAnchor.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML public void cartMenu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KioskFXCheckOut.fxml"));
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
