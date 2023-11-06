package com.example.movietheatreproj;

public class Seat {
    private int seatID;
    private boolean available;

    //Constructor with seat available
    public Seat(int seatID) {
        this.seatID = 0;
        this.available = true;
    }

    //Check if the seat is available
    public boolean checkAvailability() {
        return available;
    }

    //Lock the seat
    public void lockSeat() {
        if (available) {
            available = false;
        } else {
            System.out.println("Seat is already booked.");
        }
    }

    //Unlock the seat
    public void unlockSeat() {
        if (!available) {
            available = true;
        } else {
            System.out.println("Seat is already free.");
        }
    }

    // Get seat ID
    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }
}
