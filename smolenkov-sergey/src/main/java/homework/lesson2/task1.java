package homework.lesson2;

import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        System.out.println("Enter how many numbers you wanna have in massive and press 'Enter' key: ");
        int sizeOfMassive = sc.nextInt();
        int massive[] = new int[sizeOfMassive];
        int numbers[] = new int[sizeOfMassive];
        System.out.println();
        System.out.println("Enter " + sizeOfMassive + " numbers using 'Space' key and press Enter: " );
        for (int i = 0; i < sizeOfMassive; i++) {
            massive[i] = sc.nextInt();
            numbers[i] = (massive[i] +"").length();
        }
        sc.close();
        numbersLength(massive, numbers, sizeOfMassive);
    }

    private static void numbersLength(int[] massive, int[] numbers, int sizeOfMassive) {
        int max = numbers[0], min = numbers[0], big = 0, small = 0;
        for (int i = 1; i < sizeOfMassive ; i++) {
            int j = numbers[i];
            if (min > j){
                min = j;
                small = i;
            } else {
                if (max < j){
                    max = j;
                    big = i;
                }
            }
        }
        System.out.println();
        System.out.println("************");
        System.out.println();
        System.out.println("The first shortest number is: " + massive[small] + ". " + "with lenght of: " + min + ";");
        System.out.println("The first longest number is: " + massive[big] + ". " + "with lenght of: " + max + ";");
    }

}
