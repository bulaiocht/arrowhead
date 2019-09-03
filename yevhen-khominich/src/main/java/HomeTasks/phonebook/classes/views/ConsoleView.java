
package HomeTasks.phonebook.classes.views;

import HomeTasks.phonebook.classes.configs.PhoneBookConfig;
import HomeTasks.phonebook.classes.controllers.Controller;

public class ConsoleView {

    static Controller controller = new Controller();

    public static void start() {

        while (controller.mark) {
            showMenu();
            controller.start();
        }
    }

    private static void showMenu() {
        System.out.println(PhoneBookConfig.HEADER);
        System.out.println(PhoneBookConfig.MENU_MESSAGE1);
        System.out.println(PhoneBookConfig.MENU_MESSAGE2);
        System.out.println(PhoneBookConfig.MENU_MESSAGE3);
        System.out.println(PhoneBookConfig.MENU_MESSAGE4);
        System.out.println(PhoneBookConfig.MENU_MESSAGE5);
        System.out.println(PhoneBookConfig.MENU_MESSAGE6);
        System.out.println(PhoneBookConfig.MENU_MESSAGE7);
        System.out.println(PhoneBookConfig.MENU_MESSAGE_CHOICE);
    }

}
