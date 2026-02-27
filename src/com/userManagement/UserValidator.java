package com.userManagement;

import java.util.regex.Pattern;

public class UserValidator 
{
    private static final String email = "^[A-Za-z0-9+_.-]+@(.+)$";

    public static void validateEmail(String e) throws Exception 
    {
        if (!Pattern.matches(email, e)) 
        {
            throw new Exception("IInvalid Format ");
        }
    }

    public static void validatePassword(String password) throws Exception 
    {
        if (password.length() < 6) 
        {
            throw new Exception("Password length should not be < 6");
        }
    }
}
