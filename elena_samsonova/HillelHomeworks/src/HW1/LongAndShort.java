package HW1;

import java.util.Scanner;

public class LongAndShort {
    //1.Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

    private static void searchLongAndShort(int array[]) {

        int longest = 0, shortest = 0;
        int longestSize = 0;
        int shortestSize = array[0];
        for (int element : array) {
            if (longestSize < String.valueOf(element).length()) {
                longestSize = String.valueOf(element).length();
                longest = element;
            }
            if (shortestSize > String.valueOf(element).length()) {
                shortestSize = String.valueOf(element).length();
                shortest = element;
            }
        }

        System.out.println("longest" + longest + " longestSize=" + longestSize + "\nshortest=" + shortest + " shortestSize=" + shortestSize);
    }

    //2. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
    private static void searchMinDifferentDigitals(int array[]) {
        int index = 0;
        int value = 10;
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            String elementString = String.valueOf(array[i]);
            if (elementString.contains("0")) {
                count++;
            }
            if (elementString.contains("1")) {
                count++;
            }
            if (elementString.contains("2")) {
                count++;
            }
            if (elementString.contains("3")) {
                count++;
            }
            if (elementString.contains("4")) {
                count++;
            }
            if (elementString.contains("5")) {
                count++;
            }
            if (elementString.contains("6")) {
                count++;
            }
            if (elementString.contains("7")) {
                count++;
            }
            if (elementString.contains("8")) {
                count++;
            }
            if (elementString.contains("9")) {
                count++;
            }
            if (value > count) {
                value = count;
                index = i;
            }
        }
        System.out.println(array[index]);
    }

    //3. Найти количество чисел, содержащих только четные цифры, а также количество чисел с равным числом четных и нечетных цифр.
    private static void evenAndOddDigits(int array[]) {
        int countEvensOnly = 0;
        int countEquals = 0;


        for (int element : array) {
            String elementString = String.valueOf(element);
            if (!(elementString.contains("1") || elementString.contains("3") || elementString.contains("5") ||
                    elementString.contains("7") || elementString.contains("9"))) {
                countEvensOnly++;
            }
            int odds = 0;
            int evens = 0;
            for (char e : elementString.toCharArray()) {
                if ((e == '0') || (e == '2') || (e == '4') || (e == '6') || (e == '8')) {
                    evens++;
                }
                if ((e == '1') || (e == '3') || (e == '5') || (e == '7') || (e == '9')) {
                    odds++;
                }
                if (odds == evens) {
                    countEquals++;
                }
            }

        }

        System.out.println("Only digits with even numbers: " + countEvensOnly +
                "\nDigits with equal numbers of odds and evens " + countEquals);

    }

    //4. Определить является ли введенное число палиндромом

    private static void searchForPolindrom(int digit) {

        String elementString = String.valueOf(digit);
        StringBuilder elementReverse = new StringBuilder();
        elementReverse.append(elementString);
        elementReverse.reverse();
        if (elementReverse.toString().equals(elementString)) {
            System.out.println("Digit is palindrome");
        } else {
            System.out.println("Digit is NOT palindrome");
        }


    }

    //5. Определить в какую переменную вместится число. Число передавать как аргумент командной строки.

    private static void minSizeOfDigitContainer() {

        Scanner in = new Scanner(System.in);
        System.out.println("Input a number: ");
        String digit = in.nextLine();

        try {
            System.out.println(Byte.valueOf(digit) + "is byte");
            return;
        } catch (NumberFormatException ignored) {
        }

        try {
            System.out.println(Short.valueOf(digit) + "is short");
            return;
        } catch (NumberFormatException ignored) {
        }

        try {
            System.out.println(Integer.valueOf(digit) + "is int");
            return;
        } catch (NumberFormatException ignored) {
        }

        try {
            System.out.println(Float.valueOf(digit) + "is float");
            return;
        } catch (NumberFormatException ignored) {
        }
        try {
            System.out.println(Long.valueOf(digit) + "is long");
            return;
        } catch (NumberFormatException ignored) {
        }
        try {
            System.out.println(Double.valueOf(digit) + "is double");
        } catch (NumberFormatException ignored) {
        }
    }

    //6. Cконвертировать число переданное как аргумент командной строки в градусы по шкале Фаренгейта
// и в градусы по шкале Кельвина и вывести их в консоль.
    private static void converteDegree() throws NumberFormatException {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a number: ");
        String digit = in.nextLine();
        float f = Float.valueOf(digit);
        System.out.println("°F:" + (f * (9 / 5) + 32) + "\n°K: " + (f + 273.15));
    }

    //7.  Найти корни квадратного уравнения. Параметры уравнения передавать как аргументы командной строки.

    private static void solveQuadraticEquation() {
        Scanner in = new Scanner(System.in);
        System.out.println("ax^2+bx+c=0");
        double a, b, c, d;
        double x1, x2;
        System.out.println("Input а: ");
        a = in.nextDouble();
        System.out.println("Input b: ");
        b = in.nextDouble();
        System.out.println("Input c: ");
        c = in.nextDouble();

        d = Math.pow(b, 2) - (4 * a * c);
        if (d >= 0) {
            x1 = ((-1) * b + Math.sqrt(d)) / 2 * a;
            x2 = ((-1) * b - Math.sqrt(d)) / 2 * a;
            System.out.printf("x1 = " + x1 + " x2 = " + x2);
        } else if (d == 0) {
            x1 = (-1) * b;
            System.out.printf("x1, x2 = " + x1);
        } else
            System.out.print("D < 0, and I`m too lazy to solve complex equations");
    }


    public static void main(String[] args) {
        int[] array = {15, 24, 3, 1, 245, 777, 153433, 11, 6};
        System.out.println("1./");
        searchLongAndShort(array);
        System.out.println("2./");
        searchMinDifferentDigitals(array);
        System.out.println("3./");
        evenAndOddDigits(array);
        System.out.println("4./");
        searchForPolindrom(array[5]);
        System.out.println("5./");
        minSizeOfDigitContainer();
        System.out.println("6./");
        converteDegree();
        System.out.println("7./");
        solveQuadraticEquation();
    }
}
