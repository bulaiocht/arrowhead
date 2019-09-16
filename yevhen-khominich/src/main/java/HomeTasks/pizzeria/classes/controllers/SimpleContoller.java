package HomeTasks.pizzeria.classes.controllers;

import HomeTasks.pizzeria.classes.services.PizzaService;
import HomeTasks.pizzeria.classes.services.PizzeriaOpen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleContoller {

    PizzaService pizzaService;
    private int id;
    // Создать консольный интерфейс, который будет принимать команды по заказу пицц.
    {
        id=1;
        pizzaService = new PizzaService();
    }

    public static boolean mark = true;

    public void start() {
        chooseVar();
    }

    private int checkAndCorrectInput() {
        Scanner inNumber = new Scanner(System.in);
        int choice;
        try {
            choice = inNumber.nextInt();

        } catch (InputMismatchException e) {
            choice = 5;
        }
        return choice;
    }

    private void chooseVar() {

        switch (checkAndCorrectInput()) {
            case 1:
                PizzaService.showPizzas();
                break;
            case 2:
                System.out.println();
                PizzaService.createOrder(id++);
                break;
            case 3:
                System.out.println("Enter your Order ID");
                PizzaService.checkOrder(checkAndCorrectInput());
                break;
            case 4:
                PizzeriaOpen.offPizzeria();
                mark = false;
                break;
            default:
                System.out.println("Try again!");
                break;
        }

    }
}