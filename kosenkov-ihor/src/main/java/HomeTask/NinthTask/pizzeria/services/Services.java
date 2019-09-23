package HomeTask.NinthTask.pizzeria.services;

import HomeTask.NinthTask.pizzeria.entity.Chef;
import HomeTask.NinthTask.pizzeria.entity.Order;
import HomeTask.NinthTask.pizzeria.entity.Pizza;
import HomeTask.NinthTask.pizzeria.entity.Sales;
import HomeTask.NinthTask.pizzeria.utilities.Utilities;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Services {

    private Order order;
    private Chef chef;
    private Sales sales;

    private final File PROPERTIES =
            new File(String.format("kosenkov-ihor" +
                            "%ssrc" +
                            "%smain" +
                            "%sresources" +
                            "%spizza.json",
                    File.separator,
                    File.separator,
                    File.separator,
                    File.separator));

    {
        chef = new Chef();
        chef.start();
        sales = new Sales();
    }

    public String loadMenu(){
        StringBuilder menu = new StringBuilder();
        List<Pizza> pizzas = loadProperties();

        int i = 0;
        for (Pizza pizza : pizzas) {
            menu.append(++i).append(". ").append(pizza).append("\n");
        }
        return menu.toString();
    }

    public List<Pizza> loadProperties(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(PROPERTIES, new TypeReference<List<Pizza>>(){});
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean makeOrder(String stringOrder) {
        List<Pizza> pizzas = loadProperties();

        if (Utilities.isValidOrder(stringOrder)) {
            order = new Order();

            String[] orders = stringOrder.split(",");
            String[][] orders1 = new String[orders.length][];
            for (int i = 0; i < orders.length; i++) {
                orders1[i] = orders[i].split(":");
            }

            for (int i = 0; i < orders1.length; i++) {
                for (int j = 0; j < Integer.parseInt(orders1[i][1]); j++) {
                    order.addPizza(pizzas.get(Integer.parseInt(orders1[i][0])-1));
                }
            }
            System.out.println(order);
            return true;
        } else
            return false;

    }

    public void giveOrderToChef() {
        chef.takeOrder(order);
    }

    public void turnOff() {
        chef.interrupt();
    }

    public void showOrders(){
        chef.getOrders().forEach(System.out::println);
    }

    public boolean checkOrder(int orderID){
        if (!chef.isFree()&&chef.getOrders().get(0).getOrderID() > orderID) return true;
        Order order = chef.getOrders()
                .stream()
                .filter(order1 -> order1.getOrderID() == orderID)
                .findAny()
                .orElse(null);
        if (order==null) return false;
        return order.isReady();
    }

    public double payment(double cash){
        return cash - order.getOrderPrice();
    }

    public boolean makeDiscount(){
        if (sales.isOrderAmountAboveThousandUAH(order)){
            return true;
        }
        if (sales.isMothsSales(order)){
            return true;
        }
        if (sales.isFourPizzasInOrder(order)){
            return true;
        }
        return false;
    }

    public double getOrderPrice() {
        return order.getOrderPrice();
    }

}
