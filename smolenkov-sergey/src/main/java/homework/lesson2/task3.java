package homework.lesson2;

import org.jetbrains.annotations.NotNull;

public class task3 {

    //    3. Найти количество чисел, содержащих только четные цифры,
    //    а также количество чисел с равным числом четных и нечетных цифр.

    public static void main(@NotNull String[] args) {

        Integer[] arguments = new Integer[args.length];
        int i = 0;
        for (String argument : args) {
            arguments[i] = Integer.parseInt(argument);
            i++;
            System.out.println(argument);
        }

        int evenCounter = 0;
        int oddCounter = 0;
        for (int k = 0; k < arguments.length; k++) {
            int countEvenNumbers = 0;
            int countOddNumbers = 0;
            int[] valueOfElements = getCharsOfInteger(arguments[k]);
            for (int j = 0; j < valueOfElements.length; j++) {
                if (valueOfElements[j] % 2 == 0) {
                    countEvenNumbers++;
                } else {
                    countOddNumbers++;
                }
            }
            if (countEvenNumbers == countOddNumbers) {
                oddCounter++;
            }
            if (countOddNumbers == 0) {
                evenCounter++;
            }
        }
        System.out.println("Amount of numbers that contain just even digits : " + evenCounter);
        System.out.println("Amount of numbers that contains the same amount of even and odd digits: " + oddCounter);
    }

    private static int[] getCharsOfInteger(int number) {
        int[] elements = new int[(int) Math.ceil(Math.log10(number + 0.5))];
        for (int i = 0; i < elements.length; i++) {
            elements[elements.length - i - 1] = number % 10;
            number /= 10;
        }
        return elements;

    }
}

