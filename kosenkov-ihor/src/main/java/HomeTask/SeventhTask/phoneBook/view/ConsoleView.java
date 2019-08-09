package HomeTask.SeventhTask.phoneBook.view;

import HomeTask.SeventhTask.phoneBook.service.Service;
import HomeTask.SeventhTask.phoneBook.utilities.Utilities;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConsoleView {

    private String menuEng = "Select menu item:\n" +
            "1. Add new contact.\n" +
            "2. Search for a contact by name.\n" +
            "3.Contact list\n" +
            "4.Turn off";
    private String caseOneEng = "Enter the contact in the format: name/phone number:";
    private String caseTwoEng = "Enter the name:";
    private String caseFourEng = "Turn off...";

    private String menuRus = "Выберите пункт меню:\n" +
            "1. Добавить новый контакт.\n" +
            "2. Найти конкат по имени\n" +
            "3. Список контактов\n" +
            "4. Выключить";
    private String caseOneRus = "Введите контакт в формате: имя/номер телефона:";
    private String caseTwoRus = "Введите имя:";
    private String caseFourRus = "Выключение...";

    private String menu;
    private String caseOne;
    private String caseTwo;
    private String caseFour;
    private boolean work = true;

    public void run() {

        Service service = new Service();

        System.out.println("Phone Book started...");

        chooseLanguage();

        while (work) {
            System.out.println(menu);

            Scanner sc = new Scanner(System.in);
            byte choose = sc.nextByte();

            switch (choose) {
                case 1:
                    System.out.println("Enter the contact in the format: name/phone number:");
                    Scanner contact = new Scanner(System.in);
                    String result = service.addContact(contact.nextLine()) ? "Contact added" : "Invalid entry";
                    System.out.println(result);
                    break;
                case 2:
                    System.out.println("Enter the name:");
                    Scanner name = new Scanner(System.in);
                    System.out.println(service.displayContactByName(name.nextLine()));
                    break;
                case 3:
                    System.out.println(service.displayAllContacts());
                    break;
                case 4:
                    work = false;
                    System.out.println("Turn off...");
                    break;
            }

        }
        //        load("Phone Book started");

    }

    private void chooseLanguage() {
        System.out.println("Choose language:\n1.English\n2.Russian");
        Scanner scanner = new Scanner(System.in);
        byte choose = 0;
        if (scanner.hasNextByte()) {
            choose = scanner.nextByte();
        } else {
            System.out.println("Incorrect input, default language selected");
        }
        switch (choose) {
            case 1:
                menu = menuEng;
                caseOne = caseOneEng;
                caseTwo = caseTwoEng;
                caseFour = caseFourEng;
                break;
            case 2:
                menu = menuRus;
                caseOne = caseOneRus;
                caseTwo = caseTwoRus;
                caseFour = caseFourRus;
                break;
            default:
                System.out.println("Incorrect input, default language selected");
                menu = menuEng;
                caseOne = caseOneEng;
                caseTwo = caseTwoEng;
                caseFour = caseFourEng;
                break;
        }
    }

//    private void load(String str) {
//        int timeToWait = 3; //second
//        System.out.print(str);
//        try {
//
//            for (int i=0; i<timeToWait ; i++) {
//                TimeUnit.SECONDS.sleep(5);
//                System.out.print(".");
//            }
//        } catch (InterruptedException ie)
//        {
//            Thread.currentThread().interrupt();
//        }
//    }

}
