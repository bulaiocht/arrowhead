package HomeTasks.HomeTaskNineth.classes.menu;

import HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen.Chef;
import HomeTasks.HomeTaskNineth.classes.pizzeria.hall.Order;
import HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen.Pizza;
import HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen.PizzaProperty;
import HomeTasks.HomeTaskNineth.classes.pizzeria.sales.Sales;

import java.util.*;

public class Services {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Pizza> pizzas = PizzaProperty.pizzas;
    private static int id_customer = 0;
    private static final Chef CHEF = Chef.getInstance();
    private static Map<Integer,Order> query = new HashMap<>();
    private static void printerMenu (){
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
    }
    private static Pizza addToOrder(Pizza pizza,int customer){
        Pizza clone = null;
        try {
             clone = (Pizza) pizza.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clone.setCustomer(customer);

        return clone;
    }
    private static void newCustomer (){
        id_customer++;
        Pizza pizza;
        Order order = new Order(id_customer);
        System.out.println("Vil'na casa !!!");
        System.out.println("Vash zakaz №"+id_customer);
        String s = scanner.nextLine();
        printerMenu();
        pizza = choosePizza();
        Pizza pizza1 = addToOrder(pizza, id_customer);

        order.addPizzaOrder(pizza1);
        while (true){
        System.out.println("Want eshe pizzy? Y/N");
        String next = scanner.next();
        if (next.equalsIgnoreCase("y")){
            printerMenu();
            pizza = choosePizza();
            Pizza pizza2 = addToOrder(pizza, id_customer);
            order.addPizzaOrder(pizza2);
        }else{
            break;
        }
        }
        new Sales(order);
        System.out.println("Price for Order: "+ order.getPriceForOrder()+"$");
        scanner.nextInt();
        CHEF.setOrder(order);
        query.put(id_customer,order);



    }

    private static Map<Integer, Order> getQuery() {
        return query;
    }

    private static void checkOrder(int id_customer){
        if (Services.id_customer>=id_customer){

            Set<Integer> integers = query.keySet();
            for (Integer integer : integers) {
                if (integer==id_customer){

                    Order order = query.get(integer);
                    if(order.isReady()){
                        System.out.println("Vash order gotov");
                    }else {
                        System.out.println("Vash order eshe dont ready");
                    }

                }
            }
        }else {
            System.out.println("Order ne naiden!!!");
        }
    }

    private static Pizza choosePizza(){
        System.out.println("Vubirite pizzy:");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                return pizzas.get(0);

            case 2:
                return pizzas.get(1);

            case 3:
                return pizzas.get(2);

        }
        return null;

    }
    public static void menuStarter(){
        System.out.println("Pizeria PAPA JSON JAVA!!!"+
                "\n"+
                "Privetsvuet nas y vas ili vas u nas)))");
        while (true){
        System.out.println("Choose options: ");
            System.out.println("1 - Vil'na casa"+"\n"+"2 - Check order");
            int i = scanner.nextInt();
            switch (i){
                case 1:
                    newCustomer();
                    break;
                case 2:
                    System.out.println("Podskazhite nomer ordera: ");
                    int i1 = scanner.nextInt();
                    checkOrder(i1);
                    break;
                case 0:
                    System.exit(1);
        }

    }}
}
