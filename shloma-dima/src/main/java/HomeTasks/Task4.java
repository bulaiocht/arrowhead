package HomeTasks;
// Определить является ли введенное число палиндромом

import java.util.Scanner;

public class Task4 {
    public static void main(String args[]) {

        System.out.println("Введите число : ");
        int num = new Scanner(System.in).nextInt();

        if (pal(num)) {
            System.out.println(num + " палиндром");
        } else {
            System.out.println(num + " не палиндром");
        }
    }

    private static boolean pal(int num) {
        int pal = num;
        int reverse = 0;
        while (pal != 0) {
            int remainder = pal % 10;
            reverse = reverse * 10 + remainder;
            pal = pal / 10;
        }
        return num == reverse;
    }
}