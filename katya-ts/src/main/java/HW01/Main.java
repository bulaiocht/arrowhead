package HW01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Numbers01 obj = new Numbers01();
        System.out.println("Enter a line of numbers, separated by space");
        String number = scanner.nextLine();
        number += " ";
        Numbers01.findShortestAndLongestNumbers(number);
        System.out.println("=========");
        Numbers01.findLessRepeatingDigitsNumber(number);
        System.out.println("=========");
        Numbers01.findOddNumbers(number);
        scanner.close();
    }
}