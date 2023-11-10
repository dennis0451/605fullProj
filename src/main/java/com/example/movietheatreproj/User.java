package com.example.movietheatreproj;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID;
    private String userName;
//    private String userEmail;
//    private String userPassword;
    private List<Ticket> tickets; // A user can have multiple tickets

    // Constructor
    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
//        this.userEmail = userEmail;
//        this.userPassword = userPassword;
        this.tickets = new ArrayList<>();
    }

    public User(int userID, String userName, String userEmail, String userPassword) {
    }

    // Method for a user to purchase a ticket
    public boolean purchaseTicket(Theatre theatre, String movieTitle, String showTime, int seatNumber) {
        // Check if the seat is available
        if (theatre.isSeatAvailable(seatNumber)) {
            // If the seat is available, book it and create a new ticket
            boolean bookingSuccess = theatre.bookSeat(seatNumber);
            if (bookingSuccess) {
                Ticket newTicket = new Ticket(movieTitle, showTime, seatNumber, this.userID);
                tickets.add(newTicket);
                System.out.println("Ticket purchased successfully for " + movieTitle + " at " + showTime + ".");
                return true;
            }
        }
        System.out.println("Failed to purchase ticket. Seat may not be available.");
        return false;
    }

    // Method for a user to cancel a ticket
    public boolean cancelTicket(Theatre theatre, Ticket ticket) {
        int seatNumber = Integer.parseInt(ticket.getSeatNumber());
        boolean cancellationSuccess = theatre.cancelSeatBooking(seatNumber);
        if (cancellationSuccess) {
            ticket.cancelTicket();
            System.out.println("Ticket cancelled successfully for seat " + seatNumber + ".");
            return true;
        }
        System.out.println("Failed to cancel ticket for seat " + seatNumber + ".");
        return false;
    }



    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public String getUserEmail() {
//        return userEmail;
//    }

//    public void setUserEmail(String userEmail) {
//        this.userEmail = userEmail;
//    }

//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }

    public List<Ticket> getTickets() {
        return tickets;
    }

}
