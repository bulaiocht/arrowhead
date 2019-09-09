package HomeTasks.pizzeria.classes.views;

import HomeTasks.pizzeria.classes.controllers.SimpleContoller;

import java.sql.SQLOutput;

public class ConsoleView {

    static SimpleContoller controller = new SimpleContoller();

    public static void start() {

        while (controller.mark) {
            showView();
            controller.start();
        }
    }

    private static void showView() {
        System.out.println("1.Show menu of Pizzeria");
        System.out.println("2.Order pizza");
        System.out.println("3.Check order");
        System.out.println("4.Exit");
        System.out.print("Your choice : ");
    }

}
