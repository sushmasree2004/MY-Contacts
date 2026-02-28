package com.main;

import com.userManagement.*;
import com.ContactManagement.*;

public class Main 
{
	public static void main(String[] args) throws Exception 
	{
		// UC-01: Registration
		User freeUser = UserFactory.createUser("FreeUser", "Sushma", "sushma@gmail.com", "pass123");
		System.out.println("Registered: " + freeUser);


		// UC-02: Authentication
		SessionManager session = SessionManager.getInstance();
		session.login(freeUser, new BasicAuth(), "pass123")
		.ifPresentOrElse(
				u -> System.out.println("Login successful: " + u.getName()),
				() -> System.out.println("Login failed")
				);


		// UC-07: Delete Contact (only logged-in user can delete)
		ContactManager manager = new ContactManager();

		Contact alice = new Contact.Builder("Alice")
				.addPhoneNumber(new PhoneNumber("Mobile", "9876543210"))
				.addEmail(new Email("Personal", "alice@gmail.com"))
				.setNotes("College friend")
				.build();

		manager.addContact(alice);

		if (session.getCurrentUser().isPresent()) 
		{
			manager.deleteContact(alice);
		} 

		else 
		{
			System.out.println("No active session. Cannot delete contact.");
		}

		// Logout
		session.logout();
		System.out.println("User logged out. Active session? " + session.getCurrentUser().isPresent());
	}
}
