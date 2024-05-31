package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    private int pin;

    // Constructor
    public AdminUser(int id, String role) {
        this.id = id;
        this.role = role;
        this.securityIncidents = new ArrayList<>();
    }

    // Implementing HIPAACompliantUser methods

    @Override
    public boolean assignPin(int pin) {
        if (String.valueOf(pin).length() < 6) {
            return false;
        }
        this.pin = pin;
        return true;
    }

    @Override
    public boolean accessAuthorized(Integer id) {
        if (!this.id.equals(id)) {
            authIncident();
            return false;
        }
        return true;
    }

    // Implementing HIPAACompliantAdmin methods

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    // Other methods

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    // Setters & Getters

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}

