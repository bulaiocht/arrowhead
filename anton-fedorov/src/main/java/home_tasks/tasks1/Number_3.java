package home_tasks.tasks1;

import java.util.List;

import static java.util.Arrays.asList;

public class Number_3 {
    //3. Найти количество чисел, содержащих только четные цифры, а также количество чисел с равным числом четных и нечетных цифр.
    public static void main(String[] args) {
        List<Integer> list = asList(22, 23, 24, 25, 24, 23, 22, 5252);
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
        System.out.println("Only even numbers: " + onlyEvenNumbers);
        System.out.println("Even and odd numbers amount the same: " + evenOddNumbers);
    }
}
