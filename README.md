# MY-Contacts

This Contact Management System has five main packages:

UserManagement → manages users, login, and sessions.
ContactManagement → handles creating, editing, and deleting contacts.
SearchContacts → provides search and filtering features.
TaggingOrganization → lets users create and apply tags to organize contacts.
main → runs and demonstrates all use cases together.





1. com.UserManagement
   
Handles users (registration, login, logout).
Supports authentication and session management.
Users can be of different types (FreeUser, PremiumUser).
Ensures only logged‑in users can perform actions on contacts.


2. com.ContactManagement
   
Handles contacts (name, phone numbers, emails, notes).
Supports create, view, edit, delete actions.
Uses builder pattern for creating contacts, and setters for editing.
Manages contact lifecycle (add/remove, cascade delete)

3. com.SearchContacts
   
Provides search and filter features.
User can search contacts by name, phone, email, or tags.
Filtering options include by tag, date added, and frequency of contact.
Uses simple loops, conditions, and comparators for searching and sorting.

4.com.TaggingOrganization

Handles tags (like Family, Work, Friends).
Users can create tags and apply/remove tags to/from contacts.
Maintains the relationship between contacts and tags using a Set.
Ensures tags are unique with equals() and hashCode()
