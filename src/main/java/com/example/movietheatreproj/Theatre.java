package com.example.movietheatreproj;

import java.util.Arrays;

public class Theatre {
    private final boolean[] seats = new boolean[20];//20 seats in the theatre
    private final String theatreName;

    //Constructor that initializes all seats to true (available)
    public Theatre(String theatreName) {
        this.theatreName = theatreName;
        //All seats are initially available
        Arrays.fill(seats, true);
    }

    //checks the availability of a seat
    public boolean isSeatAvailable(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= seats.length) {
            return seats[seatNumber - 1]; // Array is 0-based, seat numbers are 1-based
        } else {
            System.out.println("Invalid seat number.");
            return false;
        }
    }

    // Method to book a seat
    public boolean bookSeat(int seatNumber) {
        if (isSeatAvailable(seatNumber)) {
            seats[seatNumber - 1] = false; //Seat is now booked
            System.out.println("Seat " + seatNumber + " has been successfully booked.");
            return true;
        } else {
            System.out.println("Seat " + seatNumber + " is not available.");
            return false;
        }
    }

    // Method to cancel a seat booking
    public boolean cancelSeatBooking(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= seats.length && !seats[seatNumber - 1]) {
            seats[seatNumber - 1] = true; // Seat is now available
            System.out.println("Booking for seat " + seatNumber + " has been successfully cancelled.");
            return true;
        } else {
            System.out.println("Booking cancellation for seat " + seatNumber + " failed. Seat might already be available or the seat number is invalid.");
            return false;
        }
    }

    // Method to display available seats
    public void displayAvailableSeats() {
        System.out.println("Available seats for " + theatreName + ":");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println(); // New line after displaying all seats
    }

    // Getter for theatreName
    public String getTheatreName() {
        return theatreName;
    }

    // Additional methods like updating seat status, etc. can be added here.
}
