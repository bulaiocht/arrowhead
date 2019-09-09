package HomeTasks.pizzeria.classes.services;

import HomeTasks.pizzeria.classes.objects.Order;
import HomeTasks.pizzeria.classes.objects.Pizza;
import HomeTasks.pizzeria.classes.configs.PropertiesLoader;
import HomeTasks.pizzeria.type.PizzaType;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PizzaService {

    private static List<Pizza> pizzasForMenu;
    private static Map<Integer, Order> orders;

    static {
        pizzasForMenu = initializeMenu(PropertiesLoader.loadPizzasProperties());
        orders = new ConcurrentHashMap<>();
    }

    public static void showPizzas() {
        System.out.println("   Name      Type    Price  Time ID");
        for (Pizza pizza : pizzasForMenu) {
            System.out.printf("%s %s %.2f %.2f  %d\n", pizza.getName(), pizza.getType(), pizza.getPrice(), pizza.getTimeOfCooking(), pizza.getId());
        }
    }

    public static void checkOrder(int idOfOrder) {

        try {
            if (!orders.get(idOfOrder).isReady()) {
                System.out.println("Order is not ready yet");
            } else System.out.println("Order is ready");
        } catch (NullPointerException e) {
            if (orders.size() == 0) {
                System.out.println("No orders yet");
            } else System.out.println("Such Order is not exist ! Try again !");
        }


    }


//    private static boolean transferOrderToChef(Order order) {
//
//        if (orders.size() == 1 || Chef.getCurrentOrder().isReady()) {
//            System.out.println("Order is accepted");
//            Chef chef = new Chef();
//            Chef.setCurrentOrder(order);
//            chef.start();
//            return true;
//        }
//        return false;
//
//    }

    private static void transferOrderToChef(Order order) {

        Chef chef = new Chef();
        chef.setCurrentOrder(order);
        chef.setChef(chef);
        chef.start();


    }
//private static void transferOrdersToChef() {
//        Chef.setOrders(orders);
//        Chef.work();
//    }


    public static void giveCheck(Order order) {
        float account = 0;
        List<Pizza> pizzas = order.getPizzas();
        for (Pizza pizza : pizzas) {
            account += pizza.getPrice();
        }
        System.out.printf("You need to pay %.2f UAH", DiscountSystem.discountOfLimit(account));
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
                // Подумать где вызывать, что бы заказы хранились и брались постепенно как только они будут true !
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

    private static List<Pizza> initializeMenu(List<Properties> propertiesOfPizzas) {

        List<Pizza> pizzasForMenu = new ArrayList<>();

        for (Properties property : propertiesOfPizzas) {

            pizzasForMenu.add(new Pizza(
                    Integer.parseInt(property.getProperty("id")),
                    Float.parseFloat(property.getProperty("price")),
                    Float.parseFloat(property.getProperty("timeOfCooking")),
                    PizzaType.valueOf(property.getProperty("type")),
                    property.getProperty("name")));
        }

        return pizzasForMenu;
    }

    private static Pizza addPizzaToOrder(int choice) {

        return pizzasForMenu.get(choice - 1);

    }

}
