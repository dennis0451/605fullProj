package com.example.movietheatreproj;

public class Manager extends User {
    private String managerSpecialCode;

    // Constructor
    public Manager(int userID, String userName, String managerSpecialCode) {
        super(userID, userName); //calling constructor of the user class
        this.managerSpecialCode = managerSpecialCode;
    }

    // Managers can access analytics data
    public void accessAnalytics() {
        System.out.println("Accessing business analytics...");
    }

    //Update the status of a kiosk
    public void updateKioskStatus(Kiosk kiosk, boolean isOnline) {
        // Logic to update the kiosk status
        kiosk.setKioskStatus(isOnline ? "online" : "offline");
        String status = isOnline ? "online" : "offline";
        System.out.println("Kiosk " + kiosk.getKioskID() + " status updated to " + status);
    }

    // Resolve user issues
    public void resolveUserIssue(User user) {
        // Logic to resolve user issues
        System.out.println("Resolving issues for user: " + user.getUserName());
    }

    // Monitor and update inventory of concessions
    public void monitorInventory(Concession concession) {
        // Logic to monitor and possibly reorder inventory
        System.out.println("Monitoring inventory for concession item: " + concession.getConcessionType());
    }

    // Getters and Setters

    public String getManagerSpecialCode() {
        return managerSpecialCode;
    }

    public void setManagerSpecialCode(String managerSpecialCode) {
        this.managerSpecialCode = managerSpecialCode;
    }

}
