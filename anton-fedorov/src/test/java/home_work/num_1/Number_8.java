package home_work.num_1;

import java.util.Scanner;

public class Number_8 {
    /**
     * 8. Создать класс, который принимает число с плавающей точкой, введенное пользователем в консоль, и выводит его в виде целого числа и экспоненты.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number:");
        double number = scanner.nextDouble();

        String[] arr = String.valueOf(number).split("\\.");
        System.out.println("Integer: " + arr[0]);
        System.out.println("Exhibitor: " + arr[1]);
    }
}
