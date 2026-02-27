package com.userManagement;

public class OAuth implements Authentication 
{
    @Override
    public boolean authenticate(String email, String password) 
    {
       
        return email.endsWith("@gmail.com");
    }
}
