package com.SearchContacts;

import com.ContactManagement.Contact;
import java.util.*;

public class FrequencyFilter implements ContactFilter 
{
	private Map<Contact, Integer> frequencyMap = new HashMap<>();

	public void incrementFrequency(Contact contact) 
	{
		frequencyMap.put(contact, frequencyMap.getOrDefault(contact, 0) + 1);
	}

	@Override
	public List<Contact> filter(List<Contact> contacts, String criteria) 
	{
		List<Contact> sorted = new ArrayList<>(contacts);
		Collections.sort(sorted, new Comparator<Contact>() 
		{
			@Override
			public int compare(Contact c1, Contact c2) 
			{
				return frequencyMap.getOrDefault(c2, 0) - frequencyMap.getOrDefault(c1, 0);
			}
		});
		return sorted;
	}
}
