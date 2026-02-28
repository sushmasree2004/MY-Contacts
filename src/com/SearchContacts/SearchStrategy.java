package com.SearchContacts;

import com.ContactManagement.Contact;
import java.util.List;

public interface SearchStrategy 
{
	List<Contact> search(List<Contact> contacts, String query);
}
