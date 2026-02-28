package com.SearchContacts;

import com.ContactManagement.Contact;
import com.ContactManagement.Email;
import java.util.ArrayList;
import java.util.List;

public class EmailSearch implements SearchStrategy 
{
	@Override
	public List<Contact> search(List<Contact> contacts, String query) 
	{
		List<Contact> results = new ArrayList<>();

		for (Contact c : contacts) 
		{
			for (Email e : c.getEmails()) 
			{
				if (e.getAddress().equalsIgnoreCase(query)) 
				{
					results.add(c);
				}
			}
		}
		return results;
	}
}
