package com.TaggingOrganization;

import java.util.Objects;

public class Tag 
{
	private String name;

	public Tag(String name) 
	{
		if (name == null || name.trim().isEmpty()) 
		{
			throw new IllegalArgumentException("Tag name cannot be empty");
		}
		this.name = name.trim();
	}

	public String getName() 
	{
		return name;
	}

	// Ensure uniqueness in Set collections

	@Override
	public boolean equals(Object o) 
	{
		if (this == o) 
			return true;

		if (!(o instanceof Tag)) 
			return false;

		Tag tag = (Tag) o;
		return name.equalsIgnoreCase(tag.name);
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(name.toLowerCase());
	}

	@Override
	public String toString() 
	{
		return "Tag{" + name + "}";
	}
}
