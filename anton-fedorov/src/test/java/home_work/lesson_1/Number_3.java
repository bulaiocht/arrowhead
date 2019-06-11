package home_work.lesson_1;

import java.util.List;

import static java.util.Arrays.asList;

public class Number_3 {
    /**
     * 3. Найти количество чисел, содержащих только четные цифры, а также количество чисел с равным числом четных и нечетных цифр.
     */
    public static void main(String[] args) {
        List<Integer> list = asList(222, 333, 444, 22555, 222555);
        int onlyEvenNumbers = 0;
        int evenOddNumbers = 0;


        for (Integer number : list) {
            int evenAmount = 0;
            int oddAmount = 0;

            while (number > 0) {
                if ((number % 10) % 2 == 0) {
                    evenAmount++;
                } else {
                    oddAmount++;
                }
                number = number / 10;
            }

            if (evenAmount > 0 && oddAmount == 0) {
                onlyEvenNumbers++;
            }

            if (evenAmount == oddAmount) {
                evenOddNumbers++;
            }

        }
        System.out.printf("Only even numbers: %s\n", onlyEvenNumbers);
        System.out.printf("Even and odd numbers amount the same: %s", evenOddNumbers);
    }
}
