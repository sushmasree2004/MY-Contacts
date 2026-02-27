package com.userManagement;

public class UpdateEmailCommand implements ProfileCommand 
{
    private String newEmail;

    public UpdateEmailCommand(String newEmail) 
    {
        this.newEmail = newEmail;
    }

    @Override
    public void execute(User user) throws Exception 
    {
        UserValidator.validateEmail(newEmail);
        user.setEmail(newEmail);
    }
}
