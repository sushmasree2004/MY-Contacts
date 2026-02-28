package com.main;

import com.ContactManagement.*;
import com.SearchContacts.*;
import java.util.*;

public class Main 
{
	public static void main(String[] args) 
	{
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

		// Tag filter
		ContactFilter tagFilter = new TagFilter();
		System.out.println("Filter by tag 'VIP': " + tagFilter.filter(contacts, "VIP"));

		// Date filter
		ContactFilter dateFilter = new DateAddedFilter();
		System.out.println("Filter by date added: " + dateFilter.filter(contacts, ""));

		// Frequency filter
		FrequencyFilter freqFilter = new FrequencyFilter();
		freqFilter.incrementFrequency(alice);
		freqFilter.incrementFrequency(alice);
		freqFilter.incrementFrequency(bob);

		System.out.println("Filter by frequency: " + freqFilter.filter(contacts, ""));
	}
}
