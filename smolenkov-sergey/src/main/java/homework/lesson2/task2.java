package homework.lesson2;

import org.jetbrains.annotations.NotNull;

public class task2 {

//    2. Найти число, в котором число различных цифр минимально.
//    Если таких чисел несколько, найти первое из них.

    public static void main(@NotNull String[] args) {

        Integer[] arguments = new Integer[args.length];
        int numeral = 0;
        for (String argument : args) {
            arguments[numeral] = Integer.parseInt(argument);
            numeral++;
            System.out.println(argument);
        }

        int[] countArray = new int[arguments.length];

        int minValueOfDifferentNumbers = 0;
        int minValueOfDifferentNumbersIndex = 0;

        for (int i = 0; i < arguments.length; i++) {
            int count = 0;
            int[] valueOfElements = getCharsOfInteger(arguments[i]);
            for (int j = 0; j < valueOfElements.length; j++) {
                for (int k = j + 1; k < valueOfElements.length; k++) {
                    if (valueOfElements[j] == valueOfElements[k]) {
                        count++;
                    }
                }
            }
            countArray[i] = count;
        }

        for (int j = 0; j < countArray.length; j++) {
            if (countArray[j] > minValueOfDifferentNumbers) {
                minValueOfDifferentNumbersIndex = j;
                minValueOfDifferentNumbers = countArray[j];
            }
        }
        System.out.println("The first number with the lowest number of different digits :");

        System.out.println(arguments[minValueOfDifferentNumbersIndex]);
    }

    public static int[] getCharsOfInteger(int number) {
        int[] elements = new int[(int) Math.ceil(Math.log10(number + 0.5))];
        for (int i = 0; i < elements.length; i++) {
            elements[elements.length - i - 1] = number % 10;
            number /= 10;
        }
        return elements;
    }

}



