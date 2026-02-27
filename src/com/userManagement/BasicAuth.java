package com.userManagement;

public class BasicAuth implements Authentication 
{
    @Override
    public boolean authenticate(String email, String password) 
    {
        try 
        {
            String hashedPassword = Password.hashPassword(password);
           
            return "sushma@gmail.com".equals(email) &&
                   Password.hashPassword("pass123").equals(hashedPassword);
        } 
        catch (Exception e) 
        {
            return false;
        }
    }
}
