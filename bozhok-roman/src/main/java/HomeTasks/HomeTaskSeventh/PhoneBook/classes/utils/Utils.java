package HomeTasks.HomeTaskSeventh.PhoneBook.classes.utils;

import HomeTasks.HomeTaskSeventh.PhoneBook.classes.contacts.Contact;

import HomeTasks.HomeTaskSeventh.PhoneBook.classes.email.Email;
import HomeTasks.HomeTaskSeventh.PhoneBook.classes.readerConfig.PropertiesLoader;
import HomeTasks.HomeTaskSeventh.PhoneBook.enums.page.Pages;



import javax.mail.MessagingException;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utils {

    public static void saveOnFile (){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PropertiesLoader.PATHPHONEBOOK))){
            List<Pages> pages = Arrays.asList(Pages.values());
            bufferedWriter.write("NAME"+","+"NUMBER");
            bufferedWriter.newLine();
            for (Pages page : pages) {
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

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PropertiesLoader.PATHPHONEBOOK))){
            if (bufferedReader.readLine().equals("NAME"+","+"NUMBER")){
                        while (true) {
                            String line = bufferedReader.readLine();

                            if (line== null)break;


                                String[] contact = line.split(",");
                                if (contact.length > 2)
                                    throw new IllegalArgumentException("invalid in file");
                                addOnPage(contact[0],contact[1]);


                        }
            }else throw new FileAlreadyExistsException("NO PHONE BOOK!");




        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void addOnPage (String name,String number){
        Pages pages = Pages.valueOf(name.substring(0,1));
        pages.addContact(new Contact(name,number));
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
        getWithFile();
        Pattern pattern1 = Pattern.compile(PropertiesLoader.REGEXEMAIL,Pattern.CASE_INSENSITIVE);
        Matcher m1 = pattern1.matcher(email);
        boolean b = m1.find();
        try {
            if (m1.group().length()!=email.length())
                throw new IllegalArgumentException("Invalid");
            Email.sendEmail(email);

        }catch (IllegalStateException e){
            throw new IllegalArgumentException("Invalid");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
