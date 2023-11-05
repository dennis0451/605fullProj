package com.example.movietheatreproj;

public class Concession {
    //to make sure only there two are options
    public static final String AVAILABLE = "available";
    public static final String UNAVAILABLE = "unavailable";

    private int concessionID;
    private String concessionType;//Only popcorn or Soda
    private double concessionPrice;
    private String concessionStatus; // "available" or "unavailable"

    // Constructor
    public Concession(int concessionID, String concessionType, double concessionPrice, String concessionStatus) {
        this.concessionID = concessionID;
        this.concessionType = concessionType;
        this.concessionPrice = concessionPrice;
        this.concessionStatus = concessionStatus;
    }

    // Getters and Setters
    public int getConcessionID() {
        return concessionID;
    }

    public void setConcessionID(int concessionID) {
        this.concessionID = concessionID;
    }

    public String getConcessionType() {
        return concessionType;
    }

    public void setConcessionType(String concessionType) {
        this.concessionType = concessionType;
    }

    public double getConcessionPrice() {
        return concessionPrice;
    }

    public void setConcessionPrice(double concessionPrice) {
        this.concessionPrice = concessionPrice;
    }

    public String getConcessionStatus() {
        return concessionStatus;
    }

    public void setConcessionStatus(String concessionStatus) {
        if (AVAILABLE.equals(concessionStatus) || UNAVAILABLE.equals(concessionStatus)) {
            this.concessionStatus = concessionStatus;
        } else {
            throw new IllegalArgumentException("Invalid concession status: " + concessionStatus);
        }
    }

    //Method to represent the object as a string
    @Override
    public String toString() {
        return "Concession{" +
                "concessionID='" + concessionID + '\'' +
                ", concessionType='" + concessionType + '\'' +
                ", concessionPrice=" + concessionPrice +
                ", concessionStatus='" + concessionStatus + '\'' +
                '}';
    }


}
