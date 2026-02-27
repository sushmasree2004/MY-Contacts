package com.ContactManagement;



public class Email {
    private String type;   // e.g., Personal, Work
    private String address;

    public Email(String type, String address) {
        this.type = type;
        this.address = address;
    }

    public String getType() { return type; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return type + ": " + address;
    }
}
