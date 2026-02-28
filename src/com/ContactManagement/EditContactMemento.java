package com.ContactManagement;

import java.util.Stack;

public class EditContactMemento 
{
    private Contact contact;
    private Stack<ContactMemento> history = new Stack<>();
    private Stack<ContactMemento> redoStack = new Stack<>();

    public EditContactMemento(Contact contact) 
    {
        this.contact = contact;
    }

    // Execute edit with validation
    public void execute(String newName, String newNotes) 
    {
        // Save current state before change
        history.push(new ContactMemento(contact));
        redoStack.clear(); // reset redo history

        if (newName != null && !newName.isEmpty()) 
        {
            contact.setName(newName);
        }
        
        if (newNotes != null) 
        {
            contact.setNotes(newNotes);
        }

        System.out.println("Contact updated: " + contact);
    }

    // Undo last change
    public void undo() 
    {
        if (!history.isEmpty()) 
        {
            redoStack.push(new ContactMemento(contact)); // save current state for redo
            ContactMemento backup = history.pop();
            restore(backup);
            System.out.println("Undo applied: " + contact);
        } 
        else 
        {
            System.out.println("No changes to undo.");
        }
    }

    // Redo last undone change
    
    public void redo() 
    {
        if (!redoStack.isEmpty()) 
        {
            history.push(new ContactMemento(contact)); // save current state for undo
            ContactMemento redoState = redoStack.pop();
            restore(redoState);
            System.out.println("Redo applied: " + contact);
        } 
        
        else 
        {
            System.out.println("No changes to redo.");
        }
    }

    // Restore contact state from memento
    
    private void restore(ContactMemento memento) 
    {
        contact.setName(memento.getName());
        contact.setPhoneNumbers(memento.getPhoneNumbers());
        contact.setEmails(memento.getEmails());
        contact.setNotes(memento.getNotes());
    }
}
