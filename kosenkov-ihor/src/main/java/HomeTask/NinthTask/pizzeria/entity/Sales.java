package HomeTask.NinthTask.pizzeria.entity;


import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;

public class Sales {

    public boolean isOrderAmountAboveThousandUAH(Order order) {
        if (1000 - order.getOrderPrice() < 0){
            order.setOrderPrice(order.getOrderPrice() * 0.9);
            return true;
        } else {
            return false;
        }
    }

    public boolean isMothsSales(Order order) {
        Month month = LocalDate.now().getMonth();
        switch (month){
            case SEPTEMBER:
                Pizza septemberPizza = new Pizza();
                septemberPizza.setTitle("Мясная");
                if (order.getPizzas().contains(septemberPizza)) {
                    long count = order.getPizzas()
                            .stream()
                            .filter(septemberPizza::equals)
                            .count();
                    order.setOrderPrice(order.getOrderPrice() - (199.99 * count * 0.2));
                }
                return true;
            case OCTOBER:
                Pizza octoberPizza = new Pizza();
                octoberPizza.setTitle("Вегетарианская");
                if (order.getPizzas().contains(octoberPizza)) {
                    long count = order.getPizzas()
                            .stream()
                            .filter(octoberPizza::equals)
                            .count();
                    order.setOrderPrice(order.getOrderPrice() - (149.99 * count * 0.2));
                }
                return true;
            case NOVEMBER:
                Pizza novemberPizza = new Pizza();
                novemberPizza.setTitle("Пепперони");
                if (order.getPizzas().contains(novemberPizza)) {
                    long count = order.getPizzas()
                            .stream()
                            .filter(novemberPizza::equals)
                            .count();
                    order.setOrderPrice(order.getOrderPrice() - (129.99 * count * 0.2));
                }
                return true;
            default:
                return false;
        }
    }

    public boolean isFourPizzasInOrder(Order order) {
        List<Pizza> pizzas = order.getPizzas();
        int size = pizzas.size();
        double sale = 0;
        if (size>0) {
            pizzas.sort(Comparator.comparingDouble(Pizza::getPrice));
            for (int i = 0; i < size; i++) {
                sale += pizzas.get(i).getPrice();
            }
            order.setOrderPrice(order.getOrderPrice() - sale);
            return true;
        }
        return false;

    }

}
