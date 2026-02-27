package com.ContactManagement;

public class PhoneNumber 
{
    private String type;   // e.g., Mobile, Home, Work
    private String number;

    public PhoneNumber(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() { return type; }
    public String getNumber() { return number; }

    @Override
    public String toString() {
        return type + ": " + number;
    }
}
