package HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen;

import HomeTasks.HomeTaskNineth.classes.pizzeria.hall.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//Singleton
public class Chef  {
    private static Chef chef ;
    private Order orderOne;
    private List<Pizza> pizzaList;
    private int ID;
    private volatile List<Order> orders;
    private Queue<Order> queue;
    private Order order;
    private ChefThread run1 ;
    private ChefThread run2 ;
    private ChefThread run3 ;


    private Chef(){
        this.orders=new ArrayList<>();
        this.queue = new PriorityQueue<>();
        this.run1 = new ChefThread();
        this.run2 = new ChefThread();
        this.run3 = new ChefThread();


    }
    public static Chef getInstance(){
        if(chef==null)
            chef = new Chef();

        return chef;
    }
    public  void setOrder(Order order) {
        this.orderOne = order;
        this.pizzaList = new ArrayList<>(order.getPizzaList());
        this.ID = order.getID();
        addOrder(order);
        cooking();
    }
    public void addOrder(Order order){
        if (orders.size()==3){
            queue.add(order);
        }else{
            orders.add(order);
        }

    }
    private void goToListWithQuery(){

        if(orders.size()<3&&!queue.isEmpty()){
            orders.add(queue.poll());

        }

    }

    private void cooking(){

        while (true){

            START:{
            if(!orders.isEmpty()) {

                Order order = orders.get(0);
                if (run1.isAlive()==false){

                    run1 = new ChefThread(order);
                    run1.start();
                    orders.remove(0);
                    goToListWithQuery();
                    break START;
                }else if (!run2.isAlive()){
                    run2 = new ChefThread(order);
                    run2.start();
                    orders.remove(0);
                    goToListWithQuery();
                    break START;
                }else if (!run3.isAlive()){
                    run3 = new ChefThread(order);
                    run3.start();
                    orders.remove(0);
                    goToListWithQuery();
                    break START;
                }




            }else {
                break ;
            }
        }

        }



    }


}
