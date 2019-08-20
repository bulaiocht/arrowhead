package homework.lesson2;

import java.util.Scanner;

public class task8 {

//    8. Создать класс, который принимает число с плавающей точкой,
//    введенное пользователем в консоль, и выводит его в виде целого числа и экспоненты.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number using (,) :");
        double a = scanner.nextDouble();

        System.out.println("Integer equals = " + Math.floor(a) + ";");
        System.out.println("Exponent equals = " + Math.getExponent(a) + ";");
        scanner.close();
    }
}
