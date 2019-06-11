package HomeTasks.Lesson2;

import java.util.Scanner;

public class Palindrome {

//   4.Определить является ли введенное число палиндромом: его значение задом наперед будет таким же (например: 131, 17155171, 12121)

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number: ");
            isValuePalindrome(scanner.nextInt());
        }

        private static void isValuePalindrome(int value) {
            String enteredValue = String.valueOf(value);
            System.out.println(enteredValue.equals(new StringBuilder(enteredValue).reverse().toString()) ? "That's a polindrome" : " That's not a polindrome");
        }
    }

