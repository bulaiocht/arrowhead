package HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen;

import HomeTasks.HomeTaskNineth.classes.pizzeria.hall.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ChefThread extends Thread {

    private volatile List<Order> orders;
    private Queue<Order> queue;
    private Order order;

    public ChefThread (Order order){

        this.orders = new ArrayList<>();
        this.queue = new PriorityQueue<>();


    }



    @Override
    public void run() {

                List<Pizza> pizzaList = order.getPizzaList();
                int count = pizzaList.size();
                for (Pizza pizza : pizzaList) {
                    try {
                        sleep(pizza.getTime_cooking()*6000 );
                        pizza.setIs_cooked(true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (!order.isReady()) {
                    int countReady = 0;
                    for (Pizza pizza : pizzaList) {
                        if (pizza.isIs_cooked()) {
                            countReady++;
                        }
                    }
                    if (countReady == count) {
                        order.setReady();
                        System.out.println("Customer: №" + order.getID() + " Vash order gotov!!!");

                    }
                }

        }

    }

