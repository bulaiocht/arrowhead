package home_work.num_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Number_2 {
    /**
     * 2. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
     */
    public static void main(String[] args) {
        List<Integer> list = asList(123, 333, 12345, 1, 22, 12);

        Integer maxSymbols = Integer.MAX_VALUE;
        Integer resNum = 0;

        for (Integer number : list) {
            int innerNum = number;
            Map<Integer, Integer> map = new HashMap<>();

            while (innerNum > 0) {
                map.put(innerNum % 10, 1);
                innerNum = innerNum / 10;
            }

            int sumOfValuesInMap = map.size();

            if (sumOfValuesInMap < maxSymbols) {
                maxSymbols = sumOfValuesInMap;
                resNum = number;
            }
        }

        System.out.printf("Number with smallest amount of different signs is: %s", resNum);
    }
}
