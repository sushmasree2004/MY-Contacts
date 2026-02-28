package com.SearchContacts;

import com.ContactManagement.Contact;
import java.util.ArrayList;
import java.util.List;

public class NameSearch implements SearchStrategy 
{
	@Override
	public List<Contact> search(List<Contact> contacts, String query) 
	{
		List<Contact> results = new ArrayList<>();

		for (Contact c : contacts) 
		{
			if (c.getName().equalsIgnoreCase(query)) 
			{
				results.add(c);
			}
		}
		return results;
	}
}
