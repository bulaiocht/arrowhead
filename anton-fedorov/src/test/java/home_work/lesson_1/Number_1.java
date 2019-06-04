package home_work.lesson_1;

public class Number_1 {
    /**
     * 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
     */
    public static void main(String[] args) {
        Number[] arrNum = {123, 1234, 12345, 123456};

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

        System.out.printf("The shortest numbers is: %s and its length is: %s\n", shortEl, shortEl.length());
        System.out.printf("The longest numbers is: %s and its length is: %s", longEl, longEl.length());
    }
}
