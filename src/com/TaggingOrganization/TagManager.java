package com.TaggingOrganization;

import com.ContactManagement.Contact;
import java.util.Set;

public class TagManager 
{
	public void assignTag(Contact contact, Tag tag) 
	{
		contact.addTag(tag);
		System.out.println("Assigned tag '" + tag.getName() + "' to contact: " + contact.getName());
	}


	public void removeTag(Contact contact, Tag tag) 
	{
		contact.removeTag(tag);
		System.out.println("Removed tag '" + tag.getName() + "' from contact: " + contact.getName());
	}

	public Set<Tag> getTags(Contact contact) 
	{
		return contact.getTags();
	}
}
