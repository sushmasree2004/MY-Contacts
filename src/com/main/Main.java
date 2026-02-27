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

    }
}


