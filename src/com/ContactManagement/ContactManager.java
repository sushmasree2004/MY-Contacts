package com.ContactManagement;

import java.util.*;

public class ContactManager 
{
	private List<Contact> contacts = new ArrayList<>();

	public void addContact(Contact contact) 
	{
		contacts.add(contact);
		System.out.println("Contact added: " + contact.getName());
	}

	public void deleteContact(Contact contact) throws Exception 
	{
		if (!contacts.contains(contact)) 
		{
			throw new Exception("Contact not found!");
		}

		// Cascade delete: clear related entities before removal
		contact.setPhoneNumbers(new ArrayList<>());
		contact.setEmails(new ArrayList<>());
		contact.setNotes("");

		contacts.remove(contact);
		System.out.println("Contact deleted: " + contact.getName());
	}

	public List<Contact> getContacts() 
	{
		return new ArrayList<>(contacts);
	}
}
