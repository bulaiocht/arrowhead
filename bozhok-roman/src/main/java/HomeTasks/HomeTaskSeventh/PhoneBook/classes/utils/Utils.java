package HomeTasks.HomeTaskSeventh.PhoneBook.classes.utils;

import HomeTasks.HomeTaskSeventh.PhoneBook.classes.contacts.Contact;
import HomeTasks.HomeTaskSeventh.PhoneBook.classes.readerConfig.Properties;
import HomeTasks.HomeTaskSeventh.PhoneBook.enums.Pages;
import sun.font.DelegatingShape;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {

    public static void saveOnFile (){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Properties.PATHPHONEBOOK))){
            List<Pages> pages = Arrays.asList(Pages.values());
            for (Pages page : pages) {
                bufferedWriter.write(page.name());
                bufferedWriter.newLine();
                Iterator<Contact> iterator = page.getContacts().iterator();
                while (iterator.hasNext()){
                    Contact contact = iterator.next();
                    bufferedWriter.write(contact.getNAME()+","+contact.getNUMBER());
                    bufferedWriter.newLine();


                }bufferedWriter.flush();
            }




        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void getWithFile (){

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Properties.PATHPHONEBOOK))){
            List<Pages> pages = Arrays.asList(Pages.values());
            String line = bufferedReader.readLine();
            for (Pages page : pages) {

                    if (page.name().equals(line)) {
                        while (true) {
                            line = bufferedReader.readLine();

                            if (line== null)break;
                            if (line.length() != 1 ) {

                                String[] contact = line.split(",");
                                if (contact.length > 2)
                                    throw new IllegalArgumentException("invalid in file");
                                page.addContact(new Contact(contact[0], contact[1]));
                            } else {
                                break;
                            }

                        }
                    }

                }


        }catch (IOException e){
            e.printStackTrace();
        }}


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
        Set<Contact> contacts = pages.getContacts();
        for (Contact contact : contacts) {
            if (contact.getNAME().equals(name)) {
                System.out.println(contact);
            }else {
                System.out.println("No such contact");
            }
        }
    }
    public static void sendEmail(String email){
        Pattern pattern1 = Pattern.compile(Properties.REGEXEMAIL);
        Matcher m1 = pattern1.matcher(email);
        boolean b = m1.find();
        try {
            if (m1.group().length()!=email.length())
                throw new IllegalArgumentException("Invalid");

        }catch (IllegalStateException e){
            throw new IllegalArgumentException("Invalid");
        }



    }
    public static void showContact(){
        getWithFile();
        Pages[] pages = Pages.values();
        for (Pages page : pages) {
            System.out.println(page.name());
            Set<Contact> contacts = page.getContacts();
            if (contacts!= null){
                Iterator<Contact> iterator = contacts.iterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next());
                }
            }
        }


    }
}
