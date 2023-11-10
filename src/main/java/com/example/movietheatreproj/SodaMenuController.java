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

public class SodaMenuController {
    @FXML private AnchorPane mainAnchor;
    @FXML private Label titleLabel2;
    @FXML private Button quitButton;
    @FXML private Button backButton;
    @FXML private Button checkOutButton;
    @FXML private CheckBox oneSizeSoda;
    @FXML private TextField quantityField;
    @FXML private Button addToCartButton;

    @FXML private TableView<Concession> sodaSelectionTable;
    @FXML private TableColumn<Concession, Number> columnId;
    @FXML private TableColumn<Concession, String> columnName;
    @FXML private TableColumn<Concession, Number> columnPrice;

    //singleton instance
    Cart cart = Cart.getInstance();
    private ObservableList<Concession> cartItems = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("concessionID"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("concessionType"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("concessionPrice"));

        sodaSelectionTable.setItems(cartItems);
        refreshCartView();

    }

    private void refreshCartView() {
        Cart cart = Cart.getInstance();
        cartItems.clear();
        cartItems.addAll(cart.getItems());
    }

    public void removeFromCart(Concession concession) {
        cart.removeConcession(concession);
        cartItems.remove(concession);
    }
    @FXML
    public void addToCart(ActionEvent event) {
        if (!oneSizeSoda.isSelected()) {
            showAlert("Selection Error", "No soda size selected!", Alert.AlertType.ERROR);
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityField.getText());
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

        String sodaSize = "Canned Soda"; //Placeholder for the actual soda size selection
        double sodaPrice = 3.00; //Placeholder for the actual soda price

        for (int i = 0; i < quantity; i++) {
            Concession sodaConcession = new Concession(
                    uniqueID++,
                    sodaSize,
                    sodaPrice,
                    Concession.AVAILABLE
            );
            cart.addConcession(sodaConcession);
            cartItems.add(sodaConcession);
        }

        showAlert("Success", "Added " + quantity + " of Soda to cart.", Alert.AlertType.INFORMATION);
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
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
