package com.basics.mobilePhoneArrayList;

import com.basics.mobilePhoneArrayList.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    // attributes
    private List<Contact> myContacts;
    private String myNumber;

    // constructors
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public MobilePhone(List<Contact> myContacts) {
        this.myContacts = myContacts;
    }

    // METHODS
    // retrieve a contact
    public Contact contact(String firstName) {
        Contact contact = null;
        for (Contact c : myContacts) {
            if (c.getFirstName().equals(firstName)) {
                contact = c;
            }
        }
        return contact;
    }

    // retrieve all contacts
    public List<Contact> getMyContacts() {
        return this.myContacts;
    }

    // add a contact -- check if contact already exists using its index before adding
    public boolean addContact(Contact newContact) {
        if (findContact(newContact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(newContact);
        return true;
    }

    // finds an return the index of the contact in the arraylist
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    // finds an returns the index of the contact in Arraylist based on name -- use of a for loop is not good for performance
    private int findContact(String name) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals((name))) {
                return myContacts.indexOf(contact);
            }
        }
        return -1;
    }

    // TODO : find index of an object in an arraylist based on an attribute

    // update a contact 1 -- use of a for loop is not good for performance
    public boolean updateContact(Contact contact) {
        for (Contact c : myContacts) {
            if (c.equals(contact)) {
                c.setFirstName(contact.getFirstName());
                c.setLastName(contact.getLastName());
                c.setPhoneNumber(contact.getPhoneNumber());
            }
        }
        return true;
    }

    // update a contact 2 -- OPTIMIZED : uses set() method of arraylist
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + ", was not found");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    // returns name of contact if it exists -- OPTIMIZED : no loop used
    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    // remove a contact --- OPTIMIZED : uses predicate with removeIf() arraylist method
    public boolean removeContact(String name) {
        myContacts.removeIf(contact -> contact.getFirstName().equals(name));
        return true;
    }
    // remove contact : uses remove() arraylist method
    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted");
        return true;
    }

    // print contacts -- uses a loop
    public void printContacts() {
        System.out.println("Contact List");
        for(int i=0; i<this.myContacts.size();i++){
            System.out.println((i+1) + "." + this.myContacts.get(i).getName() + " -> "+ this.myContacts.get(i).getPhoneNumber());
        }
    }
}
