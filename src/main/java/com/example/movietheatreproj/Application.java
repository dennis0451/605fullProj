package com.example.movietheatreproj;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
//    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("KioskFXMain.fxml"));
            Parent root = loader.load();
            MainController mainController = loader.getController();
            mainController.setMainAnchor((AnchorPane) root);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //TODO test logic STARTS here
        User user = new User(1, "JohnDoe");
        Seat seat = new Seat(5);
        Concession popcorn = new Concession(1, "popcorn", 5.00, "available");
        Concession soda = new Concession(2, "soda", 3.00, "available");
        Theatre theatre = new Theatre("San Diego Movie Company");
        Kiosk kiosk = new Kiosk(100, "online", "Lobby");

        //attempt to book a seat
        boolean seatBooked = theatre.bookSeat(5);
        if (seatBooked) {
            System.out.println("Seat successfully booked.");
        } else {
            System.out.println("Seat booking failed.");
        }

        boolean seatBooked2 = theatre.bookSeat(20);
        if (seatBooked) {
            System.out.println("Seat successfully booked.");
        } else {
            System.out.println("Seat booking failed.");
        }

        //should fail
        boolean seatBooked3 = theatre.bookSeat(5);
        if (seatBooked3) {
            System.out.println("Seat successfully booked.");
        } else {
            System.out.println("Seat booking failed.");
        }

        boolean seatBooked4 = theatre.bookSeat(5);
        if (seatBooked4) {
            System.out.println("Seat successfully booked.");
        } else {
            System.out.println("Seat booking failed.");
        }


        // Generate a ticket if the seat was successfully booked
        if (seat.checkAvailability()) {
            Ticket ticket = kiosk.generateTicket(user, "The Grand Adventure", "12:00 PM", seat);
            if (ticket != null) {
                System.out.println("Ticket generated: " + ticket);
            }
        }

        // Dispense a concession item
        boolean concessionDispensed = kiosk.dispenseConcession(popcorn);
        if (concessionDispensed) {
            System.out.println("Concession dispensed: " + popcorn);
        }

        // Display the available seats
        theatre.displayAvailableSeats();

        //TODO test logic ENDS here

        launch();
    }
}