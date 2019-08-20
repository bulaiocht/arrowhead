package homework.lesson2;

import java.util.Scanner;

public class task4 {

//    4. Определить является ли введенное число палиндромом:
//    его значение задом наперед будет таким же (например: 131, 17155171, 12121)

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
        palindrome(massive, numbers, sizeOfMassive);
    }
    private static void palindrome(int[] massive, int[] numbers, int sizeOfMassive) {
        int j;
        boolean b = false;
        for (int i = 0; i < sizeOfMassive; i++) {
            int k = 0;
            j = massive[i];
            int[] array1 = new int[numbers[i]];
            while (j != 0) {
                array1[k] = j % 10;
                j = j / 10;
                k++;
            }
            j = array1.length - 1;
            for (k = 0; k < j; k++) {
                if (array1[k] == array1[j]) {
                    b = true;
                } else {
                    b = false;
                    break;
                }
                j--;
            }
            if (b) {
                System.out.println();
                System.out.println("The first palindrome is: " + massive[i] + ";");
                System.out.println();
                break;
            }
        }
        if (b == false) {
            System.out.println();
            System.out.println("There is no any palindromes;");
            System.out.println();
        }
    }
}
