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

        
    }
}


