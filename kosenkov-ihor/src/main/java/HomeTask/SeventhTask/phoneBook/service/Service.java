package HomeTask.SeventhTask.phoneBook.service;

import HomeTask.SeventhTask.phoneBook.csvAccess.CsvAccess;
import HomeTask.SeventhTask.phoneBook.entity.Contact;
import HomeTask.SeventhTask.phoneBook.utilities.Utilities;

import java.util.*;

public class Service {

    private CsvAccess csvAccess = new CsvAccess();

    private Queue<Contact> contacts = new PriorityQueue<>(Comparator.comparing(Contact::getName));

    {
        makeListOfContacts();
    }

    public boolean addContact(String contact) {
        String[] nameAndNumber = contact.split(",");
        if (Utilities.isValidContact(contact)) {
            contacts.add(new Contact(nameAndNumber[0], nameAndNumber[1]));
            save();
            return true;
        }
        return false;
    }

    public boolean removeContactByName(String name) {
        boolean isDeleted = false;
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getName().equals(name)) {
                iterator.remove();
                isDeleted = true;
                break;
            }
        }
        save();
        return isDeleted;
    }

    public String displayContactByName(String name) {
        List<Contact> contact = findConcatByName(name);
        StringBuilder result = new StringBuilder();
        contact.forEach(contact1 -> result.append(contact1.getName()).append(",").append(contact1.getNumber()).append("\n"));
        return contact.isEmpty() ? "Contact doesn't exist" : result.toString();
    }

    public String displayAllContacts() {
        StringBuilder stringBuilder = new StringBuilder();
        contacts.forEach(contact -> stringBuilder.append(contact).append("\n"));
        return stringBuilder.toString();
    }

    private List<Contact> findConcatByName(String name) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equals(name))
                result.add(contact);
        }
        return result;
    }

    private void save() {
        StringBuilder stringBuilder = new StringBuilder();
        contacts.forEach(contact -> stringBuilder.append(contact.getName()).append(",").append(contact.getNumber()).append("\n"));
        csvAccess.writeLines(stringBuilder.toString());

    }

    private void makeListOfContacts(){

        String text = csvAccess.readLines();
        if (text.isEmpty()) return;
        String[] strings = text.split("\n");
        String[][] strings1 = new String[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            strings1[i] = strings[i].split(",");
            contacts.add(new Contact(strings1[i][0], strings1[i][1]));
        }
    }

}
