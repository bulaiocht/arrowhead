package HomeTasks.HomeTaskNineth.classes.pizzeria;

import java.util.List;

public abstract class Chef  {
    private Order order;
    private List<Pizza> pizzaList;
    private int ID;

    public void setOrder(Order order) {
        this.order = order;
        this.pizzaList.addAll(order.getPizzaList());
        this.ID = order.getID();
        cooking();
    }

    private void cooking(){
        for (Pizza pizza : pizzaList) {
            new ChefThread(pizza).start();
        }
        Thread run = new Thread() {
            @Override
            public void run() {
                int count = pizzaList.size();
                while (!order.isReady()){
                    int countReady= 0;
                    for (Pizza pizza : pizzaList) {
                        if (pizza.IS_COOKED()){
                            countReady++;
                        }
                    }
                    if (countReady==count){
                        order.setReady();
                        
                    }
                }
            }
        };
        run.start();

    }


}
