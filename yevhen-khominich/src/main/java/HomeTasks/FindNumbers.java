package HomeTasks;//ДЗ 1-3
//1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
//2. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
//3. Найти количество чисел, содержащих только четные цифры, а также количество чисел с равным числом четных и нечетных цифр.

public class FindNumbers {
    public static void main(String[] args) {
        shortAndLong(args);
        findNumberWithMinDifferences(args);
        calculateOnlyEvenNumbers(args);
        calculateQualEvenAndOdd(args);
    }

    private static void shortAndLong(String[] numbers) {
        String shortNumber = numbers[0];
        String longNumber = numbers[0];
        int sizeShortNumber, sizeLongNumber;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i].length() < shortNumber.length()) {
                shortNumber = numbers[i];

            }
            if (numbers[i].length() > longNumber.length()) {
                longNumber = numbers[i];
            }

        }
        sizeShortNumber = shortNumber.length();
        sizeLongNumber = longNumber.length();
        System.out.println("Long number = " + longNumber + " " + "It size is:" + sizeLongNumber);
        System.out.println("Short number = " + shortNumber + " " + "It size is:" + sizeShortNumber);
    }

    private static void findNumberWithMinDifferences(String[] numbers) {

        int[] counters = new int[numbers.length];
        int k = 0;
        int countMatches = 0;

        while (k != numbers.length) {
            for (int i = 0; i < numbers[k].length() - 1; i++) {
                for (int j = i + 1; j < numbers[k].length(); j++) {
                    if (numbers[k].charAt(i) == numbers[k].charAt(j)) {
                        countMatches++;
                        i++;
                    }
                }
            }
            counters[k] = countMatches;
            countMatches = 0;
            k++;
        }
        int index = 0;
        for (int i = 1; i < counters.length; i++) {
            if (counters[index] < counters[i]) {
                index = i;
            }
        }
        System.out.println("NumberWithMinimalDifferences = " + numbers[index]);
    }

    private static void calculateOnlyEvenNumbers(String[] numbers) {
        int k = 0, countOnlyEven = 0;

        while (k != numbers.length) {
            boolean isEven = true;
            for (int i = 0; i < numbers[k].length(); i++) {
                int p = Integer.parseInt(String.valueOf(numbers[k].charAt(i)));
                if (p % 2 != 0) isEven = false;
            }
            if (isEven) countOnlyEven++;
            k++;
        }
        System.out.println("Amount of only even numbers = " + countOnlyEven);
    }
    private static void calculateQualEvenAndOdd(String[] numbers){
        int k = 0, countQual = 0, countEven = 0, countOdd = 0;
        int[] even = new int[numbers.length];
        int[] odd = new int[numbers.length];

        while (k != numbers.length) {
            for (int i = 0; i < numbers[k].length(); i++) {
                int p = Integer.parseInt(String.valueOf(numbers[k].charAt(i)));

                if (p % 2 != 0) countOdd++;
                else countEven++;
            }

            even[k] = countEven;
            odd[k] = countOdd;
            countOdd = 0;
            countEven = 0;
            k++;
        }

        for (int i = 0; i < odd.length; i++) {
            if (odd[i] == even[i]) countQual++;
        }
        System.out.println("Amount of qual even and odd numbers = " + countQual);
    }

}



