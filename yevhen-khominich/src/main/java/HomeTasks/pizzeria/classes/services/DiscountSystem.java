package HomeTasks.pizzeria.classes.services;


public class DiscountSystem {
    final private static float limit = 400;

    // скидка по лимиту
    public static float discountOfLimit(float account) {
        float bonus = 0;
        if (account >= limit) {
            bonus = account * 0.1f;
        }
        return account - bonus;
    }

    // пицца в подарок
//    public static float buyTwoThirdFree(List<Pizza> pizzas, float sum) {
//        sum = 0;
//        int number = pizzas.size();
//        int freePizzas = number / 3;
//        if (number % 3 == 0) {
//
//        }
//        for (int i = freePizzas - 1; i < number; i++) {
//
//            sum += pizzas.get(i).getPrice();
//        }
//
//        return 0;
//    }

    public void chooseDiscount() {
    }
}
