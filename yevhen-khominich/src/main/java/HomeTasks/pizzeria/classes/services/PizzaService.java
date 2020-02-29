package HomeTasks.pizzeria.classes.services;

import HomeTasks.pizzeria.classes.DataLoader.IMenu;
import HomeTasks.pizzeria.classes.DataLoader.JsonLoader;
import HomeTasks.pizzeria.classes.objects.Order;
import HomeTasks.pizzeria.classes.objects.Pizza;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class PizzaService {

    private static List<Pizza> pizzasForMenu;
    private static Map<Integer, Order> orders;

    public PizzaService() {

    }

    static {
        pizzasForMenu = initializeMenu(new JsonLoader());
        orders = new ConcurrentHashMap<>();
    }

    public static void showPizzas() {
        System.out.println("   Name      Type    Price  Time ID");
        for (Pizza pizza : pizzasForMenu) {
            System.out.printf("%s %s %.2f %.2f  %d\n", pizza.getName(), pizza.getType(), pizza.getPrice(), pizza.getTimeOfCooking(), pizza.getId());
        }
    }

    public static void checkOrder(int idOfOrder) {

        Optional<Order> order = Optional.ofNullable(orders.get(idOfOrder));

        if (Optional.empty().equals(order)) {
            System.out.println("Such Order is not exist ! Try again !");
        } else if (!order.get().isReady()) {
            System.out.println("Order is not ready yet");
        } else System.out.println("Order is ready");

    }

    public static void transferOrderToChef(Order order) {

        Chef.addToChef(order);
//        Chef chef = new Chef();
//        chef.setCurrentOrder(order);
//        chef.setChef(chef);
//        chef.start();
    }

    public static void giveCheck(Order order) {

        System.out.printf("You need to pay %.2f UAH", DiscountSystem.moneyToPay(order));
    }

    public static void notifyAboutOrder(Order order) {
        System.out.println();
        System.out.printf(" Order %d is ready ! Take all your pizzas ", order.getIdOfOrder());
    }

    public static void notifyAboutPizza(Pizza pizza, Order order) {

        System.out.println();
        System.out.printf("Pizza %s from order %d is ready, enjoy!", pizza.getName(), order.getIdOfOrder());

    }

    public static void createOrder(int id) {

        Order order = new Order(id);
        System.out.printf("Your Order ID is %d\n", order.getIdOfOrder());
        System.out.println("To finish order press 0 !");

        while (true) {
            int choice = inputCorrect();

            //exit from method
            if (choice == 0) {
                orders.put(id, order);
                PizzaService.transferOrderToChef(order);
                break;
            }

            order.getPizzas().add(addPizzaToOrder(choice));
        }
    }

    private static int inputCorrect() {

        System.out.println("Indicate Pizza ID : ");
        int choice = new Scanner(System.in).nextInt();

        if (choice > pizzasForMenu.size()) {
            System.out.println("No pizza with this id ! Try again !");
            return inputCorrect();
        }

        return choice;
    }

    private static List<Pizza> initializeMenu(IMenu pizzasMenu) {
        return pizzasMenu.getPizzas();
    }

    private static Pizza addPizzaToOrder(int choice) {
        return pizzasForMenu.get(choice - 1);
    }

}
