package HomeTasks.HomeTaskNineth.classes.pizzeria.sales;

import HomeTasks.HomeTaskNineth.classes.pizzeria.hall.Order;
import HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen.Pizza;

import java.time.LocalDate;
import java.time.Month;

public class Sales {
    private static final Month MONTH = LocalDate.now().getMonth();

    public Sales (Order order){
        salesOne(order);
        salesTwo(order);
        salesThree(order);
    }
    //скидка если 4 или больше пиц то скидка 10 процентов от сумы
    private void salesOne(Order order){
        if (order.getPizzaList().size()>=4){
           order.setPriceForOrder(order.getPriceForOrder()-(order.getPriceForOrder()/100*10));
        }
    }
    // скидка если сейчас февраль то скидка на 1 пиццу 10 процентов
    private void salesTwo(Order order){
        if (Month.FEBRUARY == MONTH){
            for (Pizza pizza : order.getPizzaList()) {
                if (pizza.getId()==1){
                    pizza.setPrice(pizza.getPrice()-(pizza.getPrice()/100*10));
                }
            }
        }
    }
    // скидка каждая 3 пицца бесплатно
    private void salesThree(Order order){
        int size = order.getPizzaList().size()/3;
        for (int i = 1; i<=size ; i++) {
            order.getPizzaList().get(i*3).setPrice(0);
        }
    }
}
