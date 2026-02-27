package com.userManagement;

import java.security.MessageDigest;

public class Password 
{
    public static String hashPassword(String password) throws Exception 
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] h = md.digest(password.getBytes("UTF-8"));

        StringBuilder sb = new StringBuilder();
        for (byte b : h) 
        {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }
}
