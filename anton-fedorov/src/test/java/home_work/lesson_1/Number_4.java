package home_work.lesson_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Number_4 {
    /**
     * 4. Определить является ли введенное число палиндромом: его значение задом наперед будет таким же (например: 131, 17155171, 12121)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entered a number to check is it a palindrome:");
        long initNumber = scanner.nextLong();

        List<Long> longList = new ArrayList<>();

        long number = initNumber;
        while (number > 0) {
            longList.add(number % 10);
            number = number / 10;
        }

        List<Long> resList = new ArrayList<>(longList);
        Collections.reverse(resList);

        boolean res = longList.equals(resList);

        System.out.printf("\nEntered number: %s is a palindrome: %s\n", initNumber, res);
    }
}
