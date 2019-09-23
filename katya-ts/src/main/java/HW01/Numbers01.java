package HW01;
import java.util.Arrays;

public class Numbers01 {

    static void findShortestAndLongestNumbers(String number) {
        if (number == null)
            return;

        String shortestNumber = "";
        String longestNumber = "";
        int lengthShortestNumber = number.length();
        int lengthLongestNumber = 0;
        String[] numbers = number.split(" ");
        for (String num : numbers) {
            if (num.length() < lengthShortestNumber) {
                shortestNumber = num;
                lengthShortestNumber = num.length();
            }
            if (num.length() > lengthLongestNumber) {
                longestNumber = num;
                lengthLongestNumber = num.length();
            }
        }

        System.out.println("The shortest number is " + shortestNumber + " with " + lengthShortestNumber +
                ((lengthShortestNumber == 1) ? " digit." : " digits."));
        System.out.println("The longest number is " + longestNumber + " with " + lengthLongestNumber + " digits.");
    }


    static void findLessRepeatingDigitsNumber(String number) {
        if (number == null)
            return;
        String[] split = number.split(" ");
        int[] numbers = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }
        for (Integer num : numbers) {
            int temp = num;
            int[] digitArray = new int[10];
            int remainder = 0;
            int occurrence = 0;

            while (temp > 0) {
                remainder = temp % 10;
                digitArray[remainder]++;
                temp = temp / 10;
            }
            for (int c = 0; c < digitArray.length; c++) {
                int digitCount = digitArray[c];
                if (digitCount != 0) {
                    occurrence++;
                }
            }
            System.out.println(num + " consists of " + occurrence + ((occurrence == 1) ? " number." : " different numbers."));
        }

//        int[] occurrenceArray = new int[numbers.length];
//        Arrays.fill(occurrenceArray, occurrence);
//        System.out.println(Arrays.toString(occurrenceArray));
    }

    static void findOddNumbers(String number){
        if (number == null)
            return;
        String[] split = number.split(" ");
        int[] numbers = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }
        for (Integer num : numbers) {
            int even_count = 0;
            int odd_count = 0;
            System.out.println("For " + num + " :");
            while (num > 0){
                int rem = num % 10;
                if (rem % 2 == 0)
                    even_count++;
                else
                    odd_count++;
                num = num / 10;
            }
            System.out.println ("Even count : " + even_count + ". Odd count : " + odd_count);
            if (odd_count == 0){
                System.out.println("This element consists of even numbers only.");}
            if (odd_count == even_count){
            System.out.println("This element consists of equal number of odd and even numbers.");}
        }
    }


}