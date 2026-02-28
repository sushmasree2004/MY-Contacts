package com.ContactManagement;

import java.util.*;

public class ContactMemento 
{
	private final String name;
	private final List<PhoneNumber> phoneNumbers;
	private final List<Email> emails;
	private final String notes;

	
	// Snapshot of contact state

	public ContactMemento(Contact contact) 
	{
		this.name = contact.getName();
		this.phoneNumbers = new ArrayList<>(contact.getPhoneNumbers()); // deep copy
		this.emails = new ArrayList<>(contact.getEmails());
		this.notes = contact.getNotes();
	}

	// Restore methods
	public String getName() 
	{
		return name;
	}


	public List<PhoneNumber> getPhoneNumbers() 
	{
		return new ArrayList<>(phoneNumbers); 
	}

	public List<Email> getEmails() 
	{
		return new ArrayList<>(emails); 
	}

	public String getNotes() 
	{
		return notes;
	}
}
