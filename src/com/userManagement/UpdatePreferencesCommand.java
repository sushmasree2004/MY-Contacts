package com.userManagement;

public class UpdatePreferencesCommand implements ProfileCommand 
{
    private String newPreferences;

    public UpdatePreferencesCommand(String newPreferences) 
    {
        this.newPreferences = newPreferences;
    }

    @Override
    public void execute(User user) 
    {
        user.setPreferences(newPreferences);
    }
}
