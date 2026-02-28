package com.main;

import com.ContactManagement.*;
import com.SearchContacts.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
    	
        // Sample contacts
        Contact alice = new Contact.Builder("Alice")
                .addPhoneNumber(new PhoneNumber("Mobile", "9876543210"))
                .addEmail(new Email("Personal", "alice@gmail.com"))
                .setNotes("VIP friend")
                .build();

        Contact bob = new Contact.Builder("Bob")
                .addPhoneNumber(new PhoneNumber("Work", "1234567890"))
                .addEmail(new Email("Work", "bob@company.com"))
                .setNotes("Colleague")
                .build();

        List<Contact> contacts = new ArrayList<>();
        contacts.add(alice);
        contacts.add(bob);
        

        // Search by name
        SearchStrategy nameSearch = new NameSearch();
        System.out.println("Search by name 'Alice': " + nameSearch.search(contacts, "Alice"));

        // Search by email
        SearchStrategy emailSearch = new EmailSearch();
        System.out.println("Search by email 'bob@company.com': " + emailSearch.search(contacts, "bob@company.com"));

        // Search by phone
        SearchStrategy phoneSearch = new PhoneSearch();
        System.out.println("Search by phone '9876543210': " + phoneSearch.search(contacts, "9876543210"));

        // Search by tag/notes
        SearchStrategy tagSearch = new TagSearch();
        System.out.println("Search by tag 'VIP': " + tagSearch.search(contacts, "VIP"));
        
    }
}
