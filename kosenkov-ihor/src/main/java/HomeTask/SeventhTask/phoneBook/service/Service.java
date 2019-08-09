package HomeTask.SeventhTask.phoneBook.service;

import HomeTask.SeventhTask.phoneBook.csvAccess.CsvAccess;
import HomeTask.SeventhTask.phoneBook.entity.Contact;
import HomeTask.SeventhTask.phoneBook.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private CsvAccess csvAccess = new CsvAccess();

    private List<Contact> contacts = new ArrayList<>();

    {
        makeListOfContacts();
    }

    public boolean addContact(String contact) {
        String[] nameAndNumber = contact.split(",");
        if (Utilities.isValidContact(contact)) {
            contacts.add(new Contact(nameAndNumber[0], nameAndNumber[1]));
            return true;
        }
        return false;
    }

    public String displayContactByName(String name) {
        Contact contact = findConcatByName(name);
        return contact != null ? contact.getName() + "," + contact.getNumber() : "Contact doesn't exist";
    }

    public String displayAllContacts() {
        StringBuilder stringBuilder = new StringBuilder();
        contacts.forEach(contact -> stringBuilder.append(contact).append("\n"));
        return stringBuilder.toString();
    }

    private Contact findConcatByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name))
                return contact;
        }
        return null;
    }

    private void makeListOfContacts(){

        String text = csvAccess.readLines();
        String[] strings = text.split("\n");
        String[][] strings1 = new String[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            strings1[i] = strings[i].split(",");
            contacts.add(new Contact(strings1[i][0], strings1[i][1]));
        }
    }

}
