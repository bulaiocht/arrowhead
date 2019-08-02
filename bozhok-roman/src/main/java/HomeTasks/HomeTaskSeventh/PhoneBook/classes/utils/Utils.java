package HomeTasks.HomeTaskSeventh.PhoneBook.classes.utils;

import HomeTasks.HomeTaskSeventh.PhoneBook.classes.contacts.Contact;
import HomeTasks.HomeTaskSeventh.PhoneBook.enums.Pages;
import HomeTasks.HomeTaskSeventh.PhoneBook.interfaces.PhoneBookPath;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static void saveOnFile (){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PhoneBookPath.FILE))){
            List<Pages> pages = Arrays.asList(Pages.values());
            for (Pages page : pages) {
                bufferedWriter.write(page.name());

                Iterator<Contact> iterator = page.getContacts().iterator();
                while (iterator.hasNext()){
                    Contact contact = iterator.next();
                    bufferedWriter.write(contact.getNAME()+";"+contact.getNUMBER());
                    bufferedWriter.newLine();


                }bufferedWriter.flush();
            }




        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void getWithFile (){

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PhoneBookPath.FILE))){
            List<Pages> pages = Arrays.asList(Pages.values());
            for (Pages page : pages) {
                String line = bufferedReader.readLine();
                while (true){
                    if (page.name().equals(line)||line.length()==1)
                        break;
                    String[] contact = line.split(";");
                    page.addContact(new Contact(contact[0],contact[2]));
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void addNewContact (String name,String number){
        Pages pages = Pages.valueOf(name.substring(0,1));
        pages.addContact(new Contact(name,number));
        saveOnFile();

    }
    public static void removeSomeContact (String name,String number){
        Pages pages = Pages.valueOf(name.substring(0,1));
        pages.removeContact(new Contact(name,number));
        saveOnFile();

    }
    public static void findSomeContactForName(String name){
        getWithFile();
        Pages pages = Pages.valueOf(name.substring(0,1));
        List<Contact> contacts = pages.getContacts();
        for (Contact contact : contacts) {
            if (contact.getNAME().equals(name)) {
                System.out.println(contact);
            }else {
                System.out.println("No such contact");
            }
        }
    }
}
