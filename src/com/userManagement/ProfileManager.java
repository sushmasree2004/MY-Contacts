package com.userManagement;

public class ProfileManager 
{
    public void executeCommand(ProfileCommand command, User user) throws Exception 
    {
        command.execute(user);
        
        System.out.println("Profile updated successfully for " + user.getName());
    }
}
