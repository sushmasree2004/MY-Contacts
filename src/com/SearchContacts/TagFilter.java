package com.SearchContacts;

import com.ContactManagement.Contact;
import java.util.ArrayList;
import java.util.List;

public class TagFilter implements ContactFilter 
{
	@Override
	public List<Contact> filter(List<Contact> contacts, String tag) 
	{
		List<Contact> results = new ArrayList<>();
		for (Contact c : contacts) 
		{
			if (c.getNotes() != null && c.getNotes().toLowerCase().contains(tag.toLowerCase())) 
			{
				results.add(c);
			}
		}
		return results;
	}
}
