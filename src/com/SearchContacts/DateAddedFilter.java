package com.SearchContacts;

import com.ContactManagement.Contact;
import java.util.*;

public class DateAddedFilter implements ContactFilter 
{
    @Override
    public List<Contact> filter(List<Contact> contacts, String criteria) 
    {
        List<Contact> sorted = new ArrayList<>(contacts);
        
        Collections.sort(sorted, new Comparator<Contact>() 
        {
            @Override
            public int compare(Contact c1, Contact c2) 
            {
                return c1.getCreatedAt().compareTo(c2.getCreatedAt());
            }
        });
        return sorted;
    }
}
