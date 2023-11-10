package com.example.movietheatreproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PopcornController {
    @FXML
    private Button addToCartButton;

    @FXML
    private Button backButton;

    @FXML
    private Button checkOutButton;

    @FXML private TableView<Concession> popcornSelectionTable;
    @FXML private TableColumn<Concession, Integer> columnId; // Should match the type used in Concession
    @FXML private TableColumn<Concession, String> columnName;
    @FXML private TableColumn<Concession, Double> columnPrice; // Should match the type used in Concession



    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private CheckBox oneSizePopcorn;

    @FXML
    private TextField quantityField;

    @FXML
    private Button quitButton;

    @FXML
    private Label smallPopcornPrice;

    @FXML
    private Label titleLabel2;

    //singleton instance
    Cart cart = Cart.getInstance();
    private ObservableList<Concession> cartItems = FXCollections.observableArrayList();



    @FXML
    private void initialize() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("concessionID"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("concessionType"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("concessionPrice"));

        popcornSelectionTable.setItems(cartItems);
        refreshCartView();
    }

    private void refreshCartView() {
        Cart cart = Cart.getInstance();
        cartItems.clear();
        cartItems.addAll(cart.getItems());
    }

    @FXML
    public void addToCart(ActionEvent event) {
        System.out.println("here");
        if (!oneSizePopcorn.isSelected()) {
            showAlert("Selection Error", "No popcorn size selected!", Alert.AlertType.ERROR);
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityField.getText());
            // Check for positive quantity
            if (quantity <= 0) {
                showAlert("Quantity Error", "Please enter a positive number for quantity.", Alert.AlertType.ERROR);
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Number Format Error", "Invalid quantity. Please enter a number.", Alert.AlertType.ERROR);
            return;
        }

        //id is size of cart plus 1 for now
        int uniqueID = cart.getItems().size() + 1;

        double popcornPrice = 5.00;

        // Create new Concession objects and add them to the cart
        for (int i = 0; i < quantity; i++) {
            Concession popcornConcession = new Concession(
                    uniqueID++,
                    "Popcorn",
                    popcornPrice,
                    Concession.AVAILABLE
            );
            cart.addConcession(popcornConcession);
            cartItems.add(popcornConcession);
        }


        showAlert("Success", "Added " + quantity + " of Popcorn to cart.", Alert.AlertType.INFORMATION);
    }



    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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

    @FXML public void cartScene(ActionEvent event) {
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
