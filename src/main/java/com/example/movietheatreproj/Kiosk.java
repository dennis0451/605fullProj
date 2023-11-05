package com.example.movietheatreproj;

public class Kiosk {
    public static final String ONLINE = "online";
    public static final String OFFLINE = "offline";

    private int kioskID;
    private String kioskStatus; // "online" or "offline"
    private String kioskLocation;

    // Constructor
    public Kiosk(int kioskID, String kioskStatus, String kioskLocation) {
        this.kioskID = kioskID;
        this.kioskStatus = kioskStatus;
        this.kioskLocation = kioskLocation;
    }

    // Generate a ticket for a user
    public Ticket generateTicket(User user, String movieTitle, String showTime, Seat seat) {
        if (!ONLINE.equals(kioskStatus)) {
            System.out.println("Kiosk is offline. Cannot generate tickets at this time.");
            return null;
        }

        // Make sure the seat is available
        if (seat.checkAvailability()) {
            seat.lockSeat(); // Lock the seat to make it unavailable
            Ticket ticket = new Ticket(movieTitle, showTime, seat.getSeatID(), user.getUserID());
            System.out.println("Ticket generated for " + movieTitle + " at " + showTime + ", Seat ID: " + seat.getSeatID());
            return ticket;
        } else {
            System.out.println("Seat is not available.");
            return null;
        }
    }

    // Dispense concession if available
    public boolean dispenseConcession(Concession concession) {
        if ("available".equals(concession.getConcessionStatus())) {
            System.out.println("Dispensing " + concession.getConcessionType());
            concession.setConcessionStatus("unavailable"); // Mark as dispensed
            return true;
        } else {
            System.out.println("Concession item is unavailable.");
            return false;
        }
    }


    // Validate a user possibly by Id or database
    public boolean validateUser(User user) {
        //save for later
        System.out.println("Validating user: " + user.getUserName());
        return true; // Assume the user is valid for this example
    }

    // Report an issue with the kiosk
    public void reportIssue(String issueDescription) {
        //saved for later
        System.out.println("Reporting issue: " + issueDescription);
    }

    // Getters and setters
    public int getKioskID() {
        return kioskID;
    }

    public String getKioskStatus() {
        return kioskStatus;
    }

    public void setKioskStatus(String kioskStatus) {
        this.kioskStatus = kioskStatus;
    }

    public String getKioskLocation() {
        return kioskLocation;
    }

    public void setKioskLocation(String kioskLocation) {
        this.kioskLocation = kioskLocation;
    }

}
