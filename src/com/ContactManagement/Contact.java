package com.ContactManagement;


import java.time.LocalDateTime;
import java.util.*;

public class Contact 
{
	private final UUID id;
	private String name;
	private List<PhoneNumber> phoneNumbers;
	private List<Email> emails;
	private String notes;
	private LocalDateTime createdAt;

	protected Contact(Builder builder) 
	{
		this.id = UUID.randomUUID();
		this.name = builder.name;
		this.phoneNumbers = builder.phoneNumbers;
		this.emails = builder.emails;
		this.notes = builder.notes;
		this.createdAt = LocalDateTime.now();
	}

	public static class Builder 
	{
		private String name;
		private List<PhoneNumber> phoneNumbers = new ArrayList<>();
		private List<Email> emails = new ArrayList<>();
		private String notes;

		public Builder(String name) 
		{
			this.name = name;
		}

		public Builder addPhoneNumber(PhoneNumber phone) 
		{
			this.phoneNumbers.add(phone);
			return this;
		}

		public Builder addEmail(Email email) 
		{
			this.emails.add(email);
			return this;
		}

		public Builder setNotes(String notes)
		{
			this.notes = notes;
			return this;
		}

		public Contact build() 
		{
			return new Contact(this);
		}
	}

	public String getName() 
	{ 
		return name; 
	}


	public List<PhoneNumber> getPhoneNumbers() 
	{
		return phoneNumbers; 
	}
	public List<Email> getEmails() 
	{ 
		return emails; 
	}
	
	public String getNotes() 
	{ 
		return notes; 
	}
	
	public UUID getId() 
	{ 
		return id; 
	}
	
	public LocalDateTime getCreatedAt() 
	{ 
		return createdAt;
	}

	@Override
	public String toString() 
	{
		return "Contact{id=" + id + ", name='" + name + "', phones=" + phoneNumbers + ", emails=" + emails + ", notes='" + notes + "', createdAt=" + createdAt + "}";
	}
}
