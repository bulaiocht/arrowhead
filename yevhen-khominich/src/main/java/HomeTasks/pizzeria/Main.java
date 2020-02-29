package HomeTasks.pizzeria;

import HomeTasks.pizzeria.classes.services.PizzeriaOpen;
import HomeTasks.pizzeria.classes.views.ConsoleView;

public class Main {
    public static void main(String[] args) {

        new PizzeriaOpen().start();
        ConsoleView.start();

    }
}
