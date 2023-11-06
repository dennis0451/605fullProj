package com.example.movietheatreproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckOutController {
    private Ticket ticket = Ticket.getInstance();

    @FXML private AnchorPane mainAnchor;
    @FXML private Label titleLabel2;
    @FXML private Button quitButton;
    @FXML private Button backButton;
    @FXML private Button paymentButton;
    @FXML private TableView<Ticket> cartTable;
    @FXML private TableColumn<Ticket, String> itemColumn;
    @FXML private TableColumn<Ticket, String> quantityColumn;
    @FXML private Label subtotalLabel;
    @FXML private Label taxLabel;
    @FXML private Label totalLabel;
    @FXML private TextField SubtotalField;
    @FXML private TextField totalField;
    @FXML private Button removeFromCart;

    @FXML public void initialize() {
        ObservableList<Ticket> selectedTickets = FXCollections.observableArrayList();
        selectedTickets.add(ticket);
        cartTable.setItems(selectedTickets);
        itemColumn.setCellValueFactory(new PropertyValueFactory<>(ticket.getMovieTitle()));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>(ticket.getSeatNumber()));
    }

    @FXML public void quitPressed(ActionEvent event) {
        ((Stage) quitButton.getScene().getWindow()).close();
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
}
