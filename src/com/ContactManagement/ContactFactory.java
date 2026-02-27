package com.ContactManagement;

public class ContactFactory {
    public static Contact createContact(String type, String name) {
        if (type.equalsIgnoreCase("Person")) {
            return new Person(new Contact.Builder(name));
        } else if (type.equalsIgnoreCase("Organization")) {
            return new Organization(new Contact.Builder(name));
        } else {
            throw new IllegalArgumentException("Unknown contact type: " + type);
        }
    }
}
