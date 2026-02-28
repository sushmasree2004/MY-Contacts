package com.ContactManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ContactBulkOperations 
{

    // Bulk delete using List
    public void deleteContacts(List<Contact> contacts) 
    {
        for (Contact c : contacts) 
        {
            System.out.println("Deleted contact: " + c.getName());
        }
        
        contacts.clear();   // remove all
    }

    
    // Bulk tag using Set (to avoid duplicates)
    public void tagContacts(Set<Contact> contacts, String tag) 
    {
        for (Contact c : contacts) 
        {
            c.setNotes(c.getNotes() + " [Tag: " + tag + "]");
            System.out.println("Tagged contact: " + c.getName());
        }
    }
    
    

    // Bulk export to file
    public void exportContacts(List<Contact> contacts, String filename) 
    {
        try (FileWriter writer = new FileWriter(filename)) 
        {
            for (Contact c : contacts) 
            {
                writer.write(c.toString() + "\n");
            }
            System.out.println("Contacts exported to " + filename);
        } 
        
        catch (IOException e) 
        {
            System.out.println("Error exporting contacts: " + e.getMessage());
        }
    }
}
