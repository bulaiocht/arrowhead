package HomeTasks;
// Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        int num1 = 33567;
        int num2 = 567;
        System.out.println("Самое длинное число :" + Math.max(num1,num2));
        System.out.println("Самое короткое число :" + Math.min(num1,num2));

        int length = (int)(Math.log10(num1)+1);
        System.out.println("Длина самого длинного числа равна " + (int)(Math.log10(num1)+1));
        int length2 = (int)(Math.log10(num2)+1);
        System.out.println("Длина самого короткого числа равна " + (int)(Math.log10(num2)+1));
    }
}
