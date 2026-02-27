

package com.main;

import com.userManagement.*;
import com.ContactManagement.*;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        // === UC-01: Registration ===
        User freeUser = UserFactory.createUser("FreeUser", "Sushma", "sushma@gmail.com", "pass123");
        System.out.println("Registered: " + freeUser);

        User premiumUser = UserFactory.createUser("PremiumUser", "Ravi", "ravi@gmail.com", "securePass");
        System.out.println("Registered: " + premiumUser);


        // === UC-02: Authentication ===
        SessionManager session = SessionManager.getInstance();
        session.login(freeUser, new BasicAuth(), "pass123")
               .ifPresentOrElse(
                   u -> System.out.println("BasicAuth login successful: " + u.getName()),
                   () -> System.out.println("BasicAuth login failed")
               );
        session.login(premiumUser, new OAuth(), "securePass")
               .ifPresentOrElse(
                   u -> System.out.println("OAuth login successful: " + u.getName()),
                   () -> System.out.println("OAuth login failed")
               );

        session.getCurrentUser()
               .ifPresentOrElse(
                   u -> System.out.println("Current session user: " + u.getName() + " (" + u.getType() + ")"),
                   () -> System.out.println("No active session")
               );



        // === UC-03: Profile Management ===
        ProfileManager manager = new ProfileManager();
        manager.executeCommand(new UpdateEmailCommand("newemail@gmail.com"), freeUser);
        manager.executeCommand(new UpdatePasswordCommand("newSecurePass"), freeUser);
        manager.executeCommand(new UpdatePreferencesCommand("Dark Mode"), freeUser);
        System.out.println("Updated profile: " + freeUser);

        session.logout();
        System.out.println("User logged out. Active session? " + session.getCurrentUser().isPresent());

        // === UC-04: Contact Management (Create Contact) ===
        Contact personContact = new Contact.Builder("Alice")
                .addPhoneNumber(new PhoneNumber("Mobile", "9876543210"))
                .addEmail(new Email("Personal", "alice@gmail.com"))
                .setNotes("College friend")
                .build();

        Contact orgContact = new Contact.Builder("TechCorp")
                .addPhoneNumber(new PhoneNumber("Work", "0807654321"))
                .addEmail(new Email("Support", "support@techcorp.com"))
                .setNotes("Vendor")
                .build();

        System.out.println("Created Person Contact: " + personContact);
        System.out.println("Created Organization Contact: " + orgContact);

    }
}


