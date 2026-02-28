package com.main;

import com.ContactManagement.*;
import com.TaggingOrganization.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
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
        

        Tag family = new Tag("Family");
        Tag work = new Tag("Work");
        Tag friends = new Tag("Friends");

        TagManager tagManager = new TagManager();

        // Assign tags
        tagManager.assignTag(alice, friends);
        tagManager.assignTag(bob, work);

        // Show tags
        System.out.println("Alice's tags: " + tagManager.getTags(alice));
        System.out.println("Bob's tags: " + tagManager.getTags(bob));
    }
}
