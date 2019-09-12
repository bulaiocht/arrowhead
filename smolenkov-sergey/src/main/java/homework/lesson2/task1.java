package homework.lesson2;

import java.util.Scanner;


public class task1 {

//    1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers you wanna have in an array and press 'Enter' key: ");
        int sizeOfArray = sc.nextInt();
        int array[] = new int[sizeOfArray];
        int numbers[] = new int[sizeOfArray];
        System.out.println();
        System.out.println("Enter " + sizeOfArray + " numbers using 'Space' key and press Enter: ");
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = sc.nextInt();
            numbers[i] = (array[i] + "").length();
        }
        sc.close();
        numbersLength(array, numbers, sizeOfArray);
    }

    private static void numbersLength(int[] array, int[] numbers, int sizeOfMassive) {
        int max = numbers[0], min = numbers[0], big = 0, small = 0;
        for (int i = 1; i < sizeOfMassive; i++) {
            int j = numbers[i];
            if (min > j) {
                min = j;
                small = i;
            } else {
                if (max < j) {
                    max = j;
                    big = i;
                }
            }
        }
        System.out.println();
        System.out.println("************");
        System.out.println();
        System.out.println("The first shortest number is: " + array[small] + ". " + "with length of: " + min + ";");
        System.out.println("The first longest number is: " + array[big] + ". " + "with length of: " + max + ";");
    }

}
