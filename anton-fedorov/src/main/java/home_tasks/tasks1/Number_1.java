package home_tasks.tasks1;

import static java.lang.String.format;

public class Number_1 {
    //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    public static void main(String[] args) {
        Number[] arrNum = {18975.5d, 12, 12.1d, 123456789.0f};

        String[] arrStr = new String[arrNum.length];
        for (int i = 0; i < arrNum.length; i++) {
            arrStr[i] = String.valueOf(arrNum[i]);
        }

        String shortEl = arrStr[0];
        String longEl = arrStr[0];

        for (String s : arrStr) {
            if (s.length() < shortEl.length()) {
                shortEl = s;
            }

            if (s.length() > shortEl.length()) {
                longEl = s;
            }

        }

        System.out.println(format("The shortest numbers is: %s and its length is: %s", shortEl, shortEl.length()));
        System.out.println(format("The longestSize numbers is: %s and its length is: %s", longEl, longEl.length()));
    }
}
