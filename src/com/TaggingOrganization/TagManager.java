package com.TaggingOrganization;

import com.ContactManagement.Contact;
import java.util.*;

public class TagManager 
{
	public void assignTag(Contact contact, Tag tag) 
	{
		contact.addTag(tag);
		System.out.println("Assigned tag '" + tag.getName() + "' to contact: " + contact.getName());
	}

	public Set<Tag> getTags(Contact contact) 
	{
		return contact.getTags();
	}
}
