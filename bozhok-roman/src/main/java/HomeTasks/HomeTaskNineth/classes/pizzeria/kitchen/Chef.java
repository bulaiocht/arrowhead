package HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen;

import HomeTasks.HomeTaskNineth.classes.pizzeria.hall.Order;

import java.util.ArrayList;
import java.util.List;

public class Chef  {
    private Order order;
    private List<Pizza> pizzaList;
    private int ID;

    public  void setOrder(Order order) {
        this.order = order;
        this.pizzaList = new ArrayList<>(order.getPizzaList());
        this.ID = order.getID();
        cooking();
    }

    private void cooking(){
        Thread run = new Thread(() -> {
            int count = pizzaList.size();
            for (Pizza pizza : pizzaList) {
                new ChefThread(pizza).start();
            }
            while (!order.isReady()){
                int countReady= 0;
                for (Pizza pizza : pizzaList) {
                    if (pizza.isIs_cooked()){
                        countReady++;
                    }
                }
                if (countReady==count){
                    order.setReady();
                    System.out.println("Customer: №"+order.getID()+" Vash order gotov!!!");

                }
            }
        });
        run.start();

    }


}
