package com.example.movietheatreproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieSeatsController {
    private Ticket ticket = Ticket.getInstance();

    @FXML private AnchorPane mainAnchor;
    @FXML private Label titleLabel2;
    @FXML private Button quitButton;
    @FXML private Button backButton;
    @FXML private Button checkOutButton;
    @FXML private GridPane seatingGrid;
    @FXML private CheckBox seat1A;
    @FXML private CheckBox seat1B;
    @FXML private CheckBox seat1C;
    @FXML private CheckBox seat2A;
    @FXML private CheckBox seat2B;
    @FXML private CheckBox seat2C;
    @FXML private CheckBox seat3A;
    @FXML private CheckBox seat3B;
    @FXML private CheckBox seat3C;
    @FXML private CheckBox seat4A;
    @FXML private CheckBox seat4B;
    @FXML private CheckBox seat4C;
    @FXML private Button addToCartButton;

    private void handleSeatSelection(String seatId) {
        if (this.ticket == null) {
            ticket = new Ticket();
        }
        this.ticket.setSeatNumber(seatId);

        Seat seat = new Seat(0);
        seat.checkAvailability();
        seat.lockSeat();
    }

    private void handleSeatDeselection(String seatId) {
        if (this.ticket != null && this.ticket.getSeatNumber().equals(seatId)) {
            this.ticket.setSeatNumber(null);
        }
    }

    @FXML public void addSeats(ActionEvent event) {
        seat1A.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("1A");
            } else {
                handleSeatDeselection("1A");
            }
        });

        seat1B.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("1B");
            } else {
                handleSeatDeselection("1B");
            }
        });
        seat1C.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("1C");
            } else {
                handleSeatDeselection("1C");
            }
        });

        seat2A.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("2A");
            } else {
                handleSeatDeselection("2A");
            }
        });
        seat2B.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("2B");
            } else {
                handleSeatDeselection("2B");
            }
        });

        seat2C.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("2C");
            } else {
                handleSeatDeselection("2C");
            }
        });
        seat3A.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("3A");
            } else {
                handleSeatDeselection("3A");
            }
        });

        seat3B.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("3B");
            } else {
                handleSeatDeselection("3B");
            }
        });
        seat3C.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("3C");
            } else {
                handleSeatDeselection("3C");
            }
        });

        seat4A.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("4A");
            } else {
                handleSeatDeselection("4A");
            }
        });
        seat4B.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("4B");
            } else {
                handleSeatDeselection("4B");
            }
        });

        seat4C.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                handleSeatSelection("4C");
            } else {
                handleSeatDeselection("4C");
            }
        });
    }
    @FXML public void returnToPreviousMenu(ActionEvent event) {
        if (!MainController.menuHistory.isEmpty()) {
            String previousMenu = MainController.menuHistory.pop();
            MainController.loadFXML(previousMenu);
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
