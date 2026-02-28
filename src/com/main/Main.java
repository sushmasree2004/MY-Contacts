package com.main;

import com.ContactManagement.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
    	
        // Create sample contacts
        Contact alice = new Contact.Builder("Alice")
                .addPhoneNumber(new PhoneNumber("Mobile", "9876543210"))
                .addEmail(new Email("Personal", "alice@gmail.com"))
                .setNotes("College friend")
                .build();

        
        Contact bob = new Contact.Builder("Bob")
                .addPhoneNumber(new PhoneNumber("Work", "1234567890"))
                .addEmail(new Email("Work", "bob@company.com"))
                .setNotes("Colleague")
                .build();

        
        List<Contact> contactList = new ArrayList<>();
        contactList.add(alice);
        contactList.add(bob);

        Set<Contact> contactSet = new HashSet<>(contactList);

        ContactBulkOperations bulkOps = new ContactBulkOperations();
        

        // Tag all contacts
        bulkOps.tagContacts(contactSet, "VIP");

        // Export all contacts
        bulkOps.exportContacts(contactList, "contacts_export.txt");

        // Delete all contacts
        bulkOps.deleteContacts(contactList);

        System.out.println("Remaining contacts: " + contactList.size());
    }
}
