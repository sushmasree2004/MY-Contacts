package com.main;

import com.ContactManagement.*;

public class Main {
    public static void main(String[] args) {
        // UC-04: Create Contact
        Contact personContact = new Contact.Builder("Alice")
                .addPhoneNumber(new PhoneNumber("Mobile", "9876543210"))
                .addEmail(new Email("Personal", "alice@gmail.com"))
                .setNotes("College friend")
                .build();

        System.out.println("Original Contact: " + personContact);

        // UC-06: Edit Contact with undo/redo
        EditContactMemento  editCommand = new EditContactMemento(personContact);

        // Modify contact
        editCommand.execute("Alice Johnson", "Best friend from college");

        // Undo modification
        editCommand.undo();

        // Redo modification
        editCommand.redo();
    }
}
