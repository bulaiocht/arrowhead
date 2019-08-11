package HomeTasks.phonebook.views;

import HomeTasks.phonebook.exceptions.IllegalNumberException;
import HomeTasks.phonebook.PhoneBook;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleView {

    static ResourceBundle bundle = ResourceBundle.getBundle("config");
    static boolean mark = true;

    public static void displayMenu() {
        while (mark) {
            menu();
        }
    }

    public static void menu() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.loadContacts();
        String name;
        String number;
        Scanner in= new Scanner(System.in);

        System.out.println(bundle.getString("menu.message"));
        System.out.println(bundle.getString("menu.message1"));
        System.out.println(bundle.getString("menu.message2"));
        System.out.println(bundle.getString("menu.message3"));
        System.out.println(bundle.getString("menu.message4"));
        System.out.println(bundle.getString("menu.message5"));

        System.out.print(bundle.getString("choice"));
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter name : ");
                name = new Scanner(System.in).nextLine();
                System.out.print("Enter number : ");
                number = new Scanner(System.in).nextLine();
                try {
                    if (!checkNumber(number))
                        throw new IllegalNumberException();
                    else phoneBook.saveContact(name, number);
                } catch (IllegalNumberException e) {
                    System.out.println("Illegal number");
                }
                break;

            case 2:
                System.out.print("Who u want to find :");
                name = new Scanner(System.in).nextLine();
                phoneBook.findContact(name);
                break;

            case 3:
                phoneBook.showExistContacts();
                break;
            case 4:
                phoneBook.exportToCsv();
                break;
            case 5:
                phoneBook.exportToCsv();
                System.out.println("Program is off!");
                mark = false;
                break;
            default:
                System.out.println("Such variant dont exist!");
                break;
        }

    }

    private static boolean checkNumber(String number) {
        Pattern regex = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = regex.matcher(number);
        return matcher.find();
    }


}
