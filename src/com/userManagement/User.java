package com.userManagement;

public class User 
{
	private String name;
	private String email;
	private String password;
	private String type;  // freeUser or PremiumUser
	private String preferences;

	private User(Builder builder) 
	{
		this.name = builder.name;
		this.email = builder.email;
		this.password = builder.password;
		this.type = builder.type;
	}

	public static class Builder 
	{
		private final String name;
		private String email;
		private String password;
		private String type;

		public Builder(String name) 
		{
			this.name = name;
		}

		public Builder setEmail(String email) 
		{
			this.email = email;
			return this;
		}

		public Builder setPassword(String password) 
		{
			this.password = password;
			return this;
		}

		public Builder setType(String type) 
		{
			this.type = type;
			return this;
		}

		public User build() 
		{
			return new User(this);
		}
	}

	// Getters
	public String getName() 
	{ 
		return name; 
	}


	public String getEmail() 
	{
		return email; 
	}


	public String getPassword() 
	{ 
		return password; 
	}

	public String getType() 
	{ 
		return type; 
	}


	public String getPreferences() 
	{ 
		return preferences; 
	}

	// Setters for UC-03
	public void setName(String name) 
	{ 
		this.name = name; 
	}

	public void setEmail(String email) throws Exception 
	{ 
		UserValidator.validateEmail(email);
		this.email = email; 
	}


	public void setPassword(String password) throws Exception 
	{ 
		UserValidator.validatePassword(password);
		this.password = Password.hashPassword(password); 
	}


	public void setType(String type) 
	{ 
		this.type = type; 
	}

	public void setPreferences(String preferences)
	{ 
		this.preferences = preferences; 
	}

	@Override
	public String toString() 
	{
		return "User{name='" + name + "', email='" + email + "', type='" + type + "', preferences='" + preferences + "'}";
	}
}
