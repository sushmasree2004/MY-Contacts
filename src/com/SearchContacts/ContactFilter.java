package com.SearchContacts;

import com.ContactManagement.Contact;
import java.util.List;

public interface ContactFilter 
{
	List<Contact> filter(List<Contact> contacts, String criteria);
}
