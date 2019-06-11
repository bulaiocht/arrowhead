package HomeTasks.Lesson2;

import org.junit.Test;

import java.util.Arrays;

public class EvenOddValues {

    /*
    3. Найти количество чисел, содержащих только четные цифры, а также количество чисел с равным числом четных и нечетных цифр.
    Not ready
     */

    public static void main(String[] args) {
        int[] arrayOfEvenAndOdd = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 13};
        int even = 0;
        int odd = 0;

        for (int i = 0; i < arrayOfEvenAndOdd.length; i++) {
            int evenCount = 0;
            int oddCount = 0;
            if (arrayOfEvenAndOdd[i] % 10 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
    }
}

