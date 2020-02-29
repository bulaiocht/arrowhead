package HomeTasks;//4.Определить является ли введенное число палиндромом: его значение задом наперед будет таким же(например: 131, 17155171, 12121)
import java.util.Scanner;

public class Polindrom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        isPalindrome(scanner.nextInt());
    }

    private static void isPalindrome(int integer) {
        String intStr = String.valueOf(integer);
        System.out.println(intStr.equals(new StringBuilder(intStr).reverse().toString()) ? "It is a Polindrom" : " Not a Polindrom");
    }
}

