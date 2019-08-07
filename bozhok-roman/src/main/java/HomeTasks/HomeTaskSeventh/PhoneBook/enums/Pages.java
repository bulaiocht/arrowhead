package HomeTasks.HomeTaskSeventh.PhoneBook.enums;


import HomeTasks.HomeTaskSeventh.PhoneBook.classes.contacts.Contact;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum Pages {
    A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;

    Set<Contact> contacts = new HashSet<>();


    public void addContact (Contact contact){
        contacts.add(contact);
    }
    public void removeContact (Contact contact){
        contacts.remove(contact);
    }

    public Set<Contact> getContacts (){
        return contacts;
    }

}
