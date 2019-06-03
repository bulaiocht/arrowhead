package home_tasks.tasks1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Number_2 {
    //2. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
    public static void main(String[] args) {
        List<Integer> list = asList(123, 1234, 12345, 12, 22, 12);
        Map<Integer, Integer> mapInit = new HashMap<>();
        mapInit.put(0, 0);
        mapInit.put(1, 0);
        mapInit.put(2, 0);
        mapInit.put(3, 0);
        mapInit.put(4, 0);
        mapInit.put(5, 0);
        mapInit.put(6, 0);
        mapInit.put(7, 0);
        mapInit.put(8, 0);
        mapInit.put(9, 0);
        Integer maxSymbols = 0;
        Integer maxNum = 0;

        for (Integer number : list) {
            Map<Integer, Integer> map = new HashMap<>(mapInit);
            while (number > 0) {
                map.replace(number % 10, map.get(number % 10)+1);
                number = number / 10;
            }
            int sum = map.values().stream().mapToInt(Integer::intValue).sum();

            if (sum > maxSymbols) {
                maxSymbols = sum;
                maxNum = number;
            }
        }

        System.out.println(maxNum);
    }
}
