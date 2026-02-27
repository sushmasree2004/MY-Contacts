package com.userManagement;
import java.util.Optional;

public class SessionManager 
{
    private static SessionManager instance;
    private User currentUser;

    private SessionManager() 
    {
    	
    }

    public static SessionManager getInstance() 
    {
        if (instance == null) 
        {
            instance = new SessionManager();
        }
        return instance;
    }

    public Optional<User> login(User user, Authentication auth, String password) 
    {
        if (auth.authenticate(user.getEmail(), password))
        {
            currentUser = user;
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public void logout() 
    {
        currentUser = null;
    }

    public Optional<User> getCurrentUser() 
    {
        return Optional.ofNullable(currentUser);
    }
}
