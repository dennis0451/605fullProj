package com.example.movietheatreproj;

public class Ticket {
    private String ticketID;
    private String movieTitle;
    private String showTime;
    private String seatNumber;
    private int userID; // Assuming userID is an integer
    private boolean active; // To keep track of the ticket's status
    private static final Ticket instance = new Ticket();
    private static int ticketCounter = 0; // Static counter to generate unique ticket IDs

    //Default Constructor
    public Ticket() {}
    // Constructor
    public Ticket(String movieTitle, String showTime, int seatNumber, int userID) {
        this.ticketID = generateTicketID();
        this.movieTitle = movieTitle;
        this.showTime = showTime;
        this.seatNumber = String.valueOf(seatNumber);
        this.userID = userID;
        this.active = true; // Ticket is active by default when created
    }

    // Generates a unique ticket ID
    private String generateTicketID() {
        return "TICKET" + (++ticketCounter); // Simple incrementing ID
    }

    // Validates the ticket
    public boolean validateTicket() {
        // Add logic to validate the ticket (e.g., against a database or a session)
        return this.active;
    }

    // Cancels the ticket
    public void cancelTicket() {
        this.active = false;
    }

    // Modify booking - for simplicity, just updating showTime and seatNumber
    public void modifyBooking(String newShowTime, String newSeatNumber) {
        if (this.active) {
            this.showTime = newShowTime;
            this.seatNumber = newSeatNumber;
            System.out.println("Booking modified successfully.");
        } else {
            System.out.println("Cannot modify a cancelled or inactive booking.");
        }
    }

    // Getters and setters for the fields

    public String getTicketID() {
        return ticketID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isActive() {
        return active;
    }

    // More logic and methods as required by your system design

    public static Ticket getInstance() {
        return instance;
    }
}
