package HomeTasks.pizzeria.classes.services;


import HomeTasks.pizzeria.classes.objects.Order;
import HomeTasks.pizzeria.classes.objects.Pizza;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public class DiscountSystem {
    final private static float limit = 650;

    // скидка по лимиту
    private static float discountOfLimit(float account) {

        float bonus = account * 0.1f;
        return account - bonus;
    }

    //пицца в подарок
    private static float buyTwoThirdFree(Order order) {
        float account = 0;
        int numberOfPizzas = order.getPizzas().size();
        int freePizzas = numberOfPizzas / 3;

        for (int i = 0; i < numberOfPizzas-freePizzas; i++) {

            account += order.getPizzas().get(i).getPrice();
        }

        return 0;
    }

    public static float moneyToPay(Order order) {
        float account = 0;

        List<Pizza> pizzas = order.getPizzas();
        for (Pizza pizza : pizzas) {
            account += pizza.getPrice();
        }
        return chooseDiscount(account, order);
    }

    //Если сумма больше лиммита то берется скидка по лимиту
    private static float chooseDiscount(float account, Order order) {
        if (account >= limit) {
            return discountOfLimit(account);
        } else return buyTwoThirdFree(order);
    }
}
