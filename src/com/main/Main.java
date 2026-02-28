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

        Tag family = new Tag("Family");
        Tag friends = new Tag("Friends");

        TagManager tagManager = new TagManager();

        
        // Assign tags
        tagManager.assignTag(alice, family);
        tagManager.assignTag(alice, friends);
        

        // Show tags
        System.out.println("Alice's tags: " + tagManager.getTags(alice));
        

        // Remove a tag
        tagManager.removeTag(alice, friends);
        System.out.println("Alice's tags after removal: " + tagManager.getTags(alice));
        
    }
}
