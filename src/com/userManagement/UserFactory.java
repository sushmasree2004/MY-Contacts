package com.userManagement;

public class UserFactory 
{
	// UserFactory---> TO CREATE multiple Users of both Free and Premium Type
    public static User createUser(String type, String name, String email, String password) 
    {
        return new User.Builder(name)
                       .setEmail(email)
                       .setPassword(password)
                       .setType(type)
                       .build();
    }
}
