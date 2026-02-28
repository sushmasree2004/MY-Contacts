package com.ContactManagement;

import java.time.LocalDateTime;
import java.util.*;

public class Contact {
    private final UUID id;
    private String name;
    private List<PhoneNumber> phoneNumbers;
    private List<Email> emails;
    private String notes;
    private final LocalDateTime createdAt;

    // Builder-based constructor
    protected Contact(Builder builder) {
        this.id = UUID.randomUUID();
        this.name = builder.name;
        this.phoneNumbers = new ArrayList<>(builder.phoneNumbers); // defensive copy
        this.emails = new ArrayList<>(builder.emails);
        this.notes = builder.notes;
        this.createdAt = LocalDateTime.now();
    }

    // Copy constructor (for UC-06 editing with Memento)
    public Contact(Contact other) {
        this.id = other.id; // keep same ID
        this.name = other.name;
        this.phoneNumbers = new ArrayList<>(other.phoneNumbers);
        this.emails = new ArrayList<>(other.emails);
        this.notes = other.notes;
        this.createdAt = other.createdAt;
    }

    // === Builder Pattern ===
    public static class Builder {
        private String name;
        private List<PhoneNumber> phoneNumbers = new ArrayList<>();
        private List<Email> emails = new ArrayList<>();
        private String notes;

        public Builder(String name) {
            this.name = name;
        }

        public Builder addPhoneNumber(PhoneNumber phone) {
            this.phoneNumbers.add(phone);
            return this;
        }

        public Builder addEmail(Email email) {
            this.emails.add(email);
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }

    // === Getters ===
    public String getName() { return name; }
    public List<PhoneNumber> getPhoneNumbers() { return new ArrayList<>(phoneNumbers); } // defensive copy
    public List<Email> getEmails() { return new ArrayList<>(emails); }
    public String getNotes() { return notes; }
    public UUID getId() { return id; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // === Setters with validation (UC-06) ===
    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes != null ? notes : "";
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = new ArrayList<>(Objects.requireNonNull(phoneNumbers));
    }

    public void setEmails(List<Email> emails) {
        this.emails = new ArrayList<>(Objects.requireNonNull(emails));
    }

    // === toString for display ===
    @Override
    public String toString() {
        return String.format(
            "Contact{id=%s, name='%s', phones=%s, emails=%s, notes='%s', createdAt=%s}",
            id, name, phoneNumbers, emails, notes != null ? notes : "N/A", createdAt
        );
    }
    
    
 // inside com.ContactManagement.Contact
    private Set<com.TaggingOrganization.Tag> tags = new HashSet<>();

    public void addTag(com.TaggingOrganization.Tag tag) {
        tags.add(tag);
    }

    public Set<com.TaggingOrganization.Tag> getTags() {
        return new HashSet<>(tags); // defensive copy
    }

}
