package HomeTasks.Lesson2;

import org.junit.Test;

public class MinMaxNumber {

    // 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

    public static void main(String[] args) {
        String[] myArray = {"3", "6", "90", "6503", "-45", "7"};

        int max = myArray[0].length();
        int maxValue = 0;
        int min = myArray[0].length();
        int minValue = 0;

        for (int i = 0; i < 6; i++) {
            if (myArray[i].length() > max) {
                max = myArray[i].length();
                maxValue = i;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (myArray[i].length() < min) {
                min = myArray[i].length();
                minValue = i;
            }
        }

        System.out.println("The longest value in array " + myArray[maxValue] + " with length = " + max);
        System.out.println("The smallest value in array " + myArray[minValue] + " with length = " + min);
    }
}
