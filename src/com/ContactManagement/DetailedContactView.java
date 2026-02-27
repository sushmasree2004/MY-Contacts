package com.ContactManagement;

import java.util.Optional;

public class DetailedContactView extends ContactViewDecorator 
{

    public DetailedContactView(Contact contact) 
    {
        super(contact);
    }

    @Override
    public String toString() 
    {
        return String.format(
            "Contact Details:\n" +
            "ID: %s\n" +
            "Name: %s\n" +
            "Phones: %s\n" +
            "Emails: %s\n" +
            "Notes: %s\n" +
            "Created At: %s\n",
            
            contact.getId(),
            contact.getName(),
            Optional.ofNullable(contact.getPhoneNumbers()).orElse(java.util.Collections.emptyList()),
            Optional.ofNullable(contact.getEmails()).orElse(java.util.Collections.emptyList()),
            Optional.ofNullable(contact.getNotes()).orElse("N/A"),
            contact.getCreatedAt()
        );
    }
}
