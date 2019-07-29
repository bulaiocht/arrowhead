package HW1;

import java.util.Scanner;

public class ExponentialRecord {
    //8. Создать класс, который принимает число с плавающей точкой, введенное пользователем в консоль,
    // и выводит его в виде целого числа и экспоненты.

    public static void converteDigit(double digit) {
        int e = 0;
        if (digit >= 1) {
            while (digit % 1 != 0) {
                e++;
                digit *= 10;
            }
            System.out.println(digit + "*10^" + e);
        } else {
            while (digit<1) {
                e++;
                digit *= 10;
            }
            System.out.println(digit + "*10^-(" + e+")");
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a number: ");
        double digit = in.nextDouble();

        converteDigit(digit);


    }
}
