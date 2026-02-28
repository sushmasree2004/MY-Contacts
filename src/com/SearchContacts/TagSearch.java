package com.SearchContacts;

import com.ContactManagement.Contact;
import java.util.ArrayList;
import java.util.List;

public class TagSearch implements SearchStrategy 
{
	@Override
	public List<Contact> search(List<Contact> contacts, String query) 
	{
		List<Contact> results = new ArrayList<>();

		for (Contact c : contacts) 
		{
			if (c.getNotes() != null && c.getNotes().toLowerCase().contains(query.toLowerCase())) 
			{
				results.add(c);
			}
		}
		return results;
	}
}
