package home_tasks.tasks1;

import java.util.List;

import static java.lang.Integer.valueOf;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;

public class FindMaxValueOfSeparateNumbers {
    //2. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
    public static void main(String[] args) {
        List<Integer> list = asList(12, 13, 14, 15, 14, 13, 12, 51);

        int max = Integer.MIN_VALUE;

        for (Integer i : list) {
            int current = 0;
            String str = valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                current += valueOf(valueOf(str.charAt(j)));
            }
            if (current > max) max = current;
        }

        System.out.println(max);
    }
}
