package com.userManagement;

public class UpdatePasswordCommand implements ProfileCommand 
{
    private String newPassword;

    public UpdatePasswordCommand(String newPassword) 
    {
        this.newPassword = newPassword;
    }

    @Override 
    public void execute(User user) throws Exception 
    {
        UserValidator.validatePassword(newPassword);
        user.setPassword(Password.hashPassword(newPassword));
    }
}
