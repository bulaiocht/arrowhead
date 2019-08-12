package HomeTask.SeventhTask.phoneBook.view;

import HomeTask.SeventhTask.phoneBook.service.Service;

import java.util.Scanner;

public class ConsoleView {

    private String menu;
    private String caseOne;
    private String caseTwo;
    private String caseFourth;
    private String caseFifth;
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
                    System.out.println(caseOne);
                    Scanner contact = new Scanner(System.in);
                    String result = service.addContact(contact.nextLine()) ? "Contact added" : "Invalid entry";
                    System.out.println(result);
                    break;
                case 2:
                    System.out.println(caseTwo);
                    Scanner name2 = new Scanner(System.in);
                    String result2 = service.removeContactByName(name2.nextLine()) ? "Contact removed" : "Contact doesn't exist";
                    System.out.println(result2);
                    break;
                case 3:
                    System.out.println(caseTwo);
                    Scanner name = new Scanner(System.in);
                    System.out.println(service.displayContactByName(name.nextLine()));
                    break;
                case 4:
                    System.out.println(caseFourth);
                    System.out.println(service.displayAllContacts());
                    break;
                case 5:
                    work = false;
                    System.out.println(caseFifth);
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
        //********************************************************************************
        //English
        String menuEng = "Select menu item:\n" +
                "1.Add new contact.\n" +
                "2.Remove contact by name.\n" +
                "3.Search for a contact by name.\n" +
                "4.Contact list\n" +
                "5.Turn off";
        String caseOneEng = "Enter the contact in the format: name,phone number:";
        String caseTwoEng = "Enter the name:";
        String caseFourthEng = "Contact list:";
        String caseFifthEng = "Turn off...";
        //Russian
        String menuRus = "Выберите пункт меню:\n" +
                "1.Добавить новый контакт.\n" +
                "2.Удалить контакт по имени.\n" +
                "3.Найти конкат по имени\n" +
                "4.Список контактов\n" +
                "5.Выключить";
        String caseOneRus = "Введите контакт в формате: имя,номер телефона:";
        String caseTwoRus = "Введите имя:";
        String caseFourthRus = "Список контактов:";
        String caseFifthRus = "Выключение...";
        //********************************************************************************

        switch (choose) {
            case 1:
                menu = menuEng;
                caseOne = caseOneEng;
                caseTwo = caseTwoEng;
                caseFourth = caseFourthEng;
                caseFifth = caseFifthEng;
                break;
            case 2:
                menu = menuRus;
                caseOne = caseOneRus;
                caseTwo = caseTwoRus;
                caseFifth = caseFourthRus;
                caseFifth = caseFifthRus;
                break;
            default:
                System.out.println("Incorrect input, default language selected");
                menu = menuEng;
                caseOne = caseOneEng;
                caseTwo = caseTwoEng;
                caseFourth = caseFourthEng;
                caseFifth = caseFifthEng;
                break;
        }
    }
}
