package HomeTask.NinthTask.pizzeria.view;

import HomeTask.NinthTask.pizzeria.entity.PizzaType;
import HomeTask.NinthTask.pizzeria.services.Services;

import java.util.Scanner;

public class ConsoleView {


    private boolean work;
    private Services services;
    private String pizzasMenu;
    private String menu = "Сделай свой выбор:\n" +
            "1.Посмотреть меню.\n" +
            "2.Сделать заказ.\n" +
            "3.Проверить заказ.\n" +
            "4.Показать все заказы.\n" +
            "5.Выйти";

    {
        work = true;
        services = new Services();
        pizzasMenu = services.loadMenu();
    }

    public void run(){

        while (work){

            System.out.println(menu);

            Scanner scanner = new Scanner(System.in);
            byte choose = scanner.nextByte();

            switch (choose) {

                case 1:
                    System.out.println(pizzasMenu);
                    break;
                case 2:
                    System.out.println("Сделай заказ в виде \"x:y,x2:y2\",\n" +
                            "где х/х2 - это номер пиццы, а у,у2 - количество\n");

                    Scanner order = new Scanner(System.in);
                    boolean successSend = sendOrder(order.nextLine());
                    if (successSend) {
                        System.out.println(services.makeDiscount()?
                                String.format("Вам сделана скидка!\nНовая цена: %.2f", services.getOrderPrice())
                                :"");
                        System.out.println("Введите сумму наличных:");
                        Scanner cash = new Scanner(System.in);
                        double change = services.payment(cash.nextDouble());
                        if (change > 0) {
                            System.out.printf("Ваша сдача: %.2fгрн\n", change);
                            System.out.println("Заказ принят!");
                            services.giveOrderToChef();
                        } else {
                            System.out.println("Недостаточно денег!");
                        }
                    } else {
                        System.out.println("Неправильно оформленный заказ. Повторите попытку.");
                    }
                    break;
                case 3:
                    System.out.println("Введите номер заказа:");
                    Scanner numberOfOrder = new Scanner(System.in);
                    int orderID = numberOfOrder.nextInt();
                    System.out.println(services.checkOrder(orderID)?"Ваш заказ готов!\n":"Ваш заказ не готов!\n");
                    //TODO check order by orderID and review all code!!!
                    break;
                case 4:
                    services.showOrders();
                    break;
                case 5:
                    services.turnOff();
                    work = false;
                    System.out.println("Пока-пока!<3");
                    break;

            }

        }

    }

    private boolean sendOrder(String stringOrder){
        return services.makeOrder(stringOrder);
    }

}
