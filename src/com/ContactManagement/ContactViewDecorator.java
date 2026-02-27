package com.ContactManagement;

public abstract class ContactViewDecorator extends Contact 
{
    protected Contact contact;

    public ContactViewDecorator(Contact contact) 
    {
        super(new Contact.Builder(contact.getName()));    // dummy builder
        this.contact = contact;
    }

    @Override
    public String toString() 
    {
        return contact.toString();
    }
}
