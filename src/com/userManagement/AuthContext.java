package com.userManagement;

public class AuthContext 
{
    private Authentication strategy;

    public AuthContext(Authentication strategy) 
    {
        this.strategy = strategy;
    }

    public boolean login(String email, String password) 
    {
        return strategy.authenticate(email, password);
    }
}
