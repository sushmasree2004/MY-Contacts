package com.SearchContacts;

import com.ContactManagement.Contact;
import com.ContactManagement.PhoneNumber;
import java.util.ArrayList;
import java.util.List;

public class PhoneSearch implements SearchStrategy 
{
	@Override
	public List<Contact> search(List<Contact> contacts, String query) 
	{
		List<Contact> results = new ArrayList<>();

		for (Contact c : contacts) 
		{
			for (PhoneNumber p : c.getPhoneNumbers()) 
			{
				if (p.getNumber().equals(query)) 
				{
					results.add(c);
				}
			}
		}
		return results;
	}
}
