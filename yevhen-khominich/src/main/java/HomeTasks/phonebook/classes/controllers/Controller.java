<<<<<<< HEAD
package HomeTasks.phonebook.classes.controllers;
=======
package classes.controllers;
>>>>>>> yevhen-khominich

import classes.configs.EmailConfig;
import classes.configs.PhoneBookConfig;
import classes.service.Email;
import classes.service.PhoneBook;
import exceptions.IllegalMailException;
import exceptions.IllegalNumberException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    public static boolean mark = true;
    private static PhoneBook phoneBook = new PhoneBook();

    public Controller() {
        phoneBook.loadContacts();
    }

    public void start() {
        chooseVar();
    }

    private static boolean checkNumber(String number) {
        Pattern regex = Pattern.compile(PhoneBookConfig.REGEX_NUMBER);
        Matcher matcher = regex.matcher(number);
        return matcher.find();
    }

    private static boolean checkEmail(String number) {
        Pattern regex = Pattern.compile(EmailConfig.REGEX_MAIL);
        Matcher matcher = regex.matcher(number);
        return matcher.find();
    }

    private void chooseVar() {

        Scanner scanner = new Scanner(System.in);
        Scanner inNumber = new Scanner(System.in);

        int var = inNumber.nextInt();

        String name;
        String number;

        switch (var) {
            case 1:
                System.out.println("Enter name : ");
                name = scanner.nextLine();
                System.out.println("Enter number : ");
                number = scanner.nextLine();

                try {
                    if (!checkNumber(number))
                        throw new IllegalNumberException();
                    else phoneBook.saveContact(name, number);
                } catch (IllegalNumberException e) {
                    System.out.println("Illegal number");
                }
                break;

            case 2:
                System.out.println("Who u want to find :");
                name = scanner.nextLine();
                phoneBook.findContact(name);
                break;

            case 3:
                phoneBook.showExistContacts();
                break;

            case 4:
                phoneBook.exportToCsv();
                System.out.println("File is exported !");
                break;

            case 5:
                System.out.println("Who u want to delete ? ");
                name = scanner.nextLine();
                phoneBook.removeContact(name);
                break;
            case 6:
                System.out.println("Who u want to send email ?");
                String user = scanner.nextLine();
                phoneBook.exportToCsv();
                if (checkEmail(user)) {

                    Email.sendTo(user);
                    System.out.println("Email is sent");

                } else try {
                    throw new IllegalMailException();
                } catch (IllegalMailException e) {
                    System.out.println("Wrong email, please try operation again !");
                }
                break;

            case 7:
                phoneBook.exportToCsv();
                System.out.println("Program is off!");
                mark = false;
                break;
            default:
                System.out.println("Such variant dont exist! So try again !");
                break;

        }
    }
}
