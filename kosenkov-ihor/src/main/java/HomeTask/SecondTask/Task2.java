package HomeTask.SecondTask;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
//        //параметр по которому сравниваем цифры
//        char token;
//        //соответствие каждой цифре количество повторений
//        int[] count;
//        //перебор чисел в масиве
//        for (int i = 0; i < args.length; i++) {
//            count = new int[args[i].length()];
//            //перебор цифр которые мы сравниваем
//            for (int j = 0; j < args[i].length(); j++) {
//                token = args[i].charAt(j);
//                //срвниваем с каждой цифрой даного числа
//                for (int k = 0; k < args[i].length(); k++) {
//                    if (args[i].charAt(k) == token){
//                        count[j]++;
//                    }
//                }
//            }
//
//        }
        //массив со значениями количсетва уникальных цифр каждого числа
        int[] countOfUnicNumber = new int[args.length];
        //перебор чисел во входящем масиве
        for (int i = 0; i < args.length; i++) {
            int[] numbers = new int[args[i].length()];
            int count = 0;

            //перебор цифр в числе чтобы распарсить цифры в инт
            for (int j = 0; j < args[i].length(); j++) {
                numbers[j] = Integer.parseInt(args[i].substring(j,j+1));
            }
            //перебор цифр в числе для определения токена
            for (int j = 0; j < numbers.length; j++) {
                int token = numbers[j];
                //перебор цифр в числе для сравнения
                for (int k = 0; k < numbers.length; k++) {
                    //замена повторных цифр на "-1"
                    if (numbers[k]==token){
                        if(k==j) continue;
                        numbers[k] = -1;
                    }
                }
            }
            //подсчет количества уникальных цифр
            for (int j = 0; j < numbers.length; j++) {
                if(numbers[j]>-1){
                    count++;
                }
            }
//            System.out.println(Arrays.toString(numbers));
            countOfUnicNumber[i] = count;
        }
//        System.out.println(Arrays.toString(countOfUnicNumber));
        //определить у какого числа меньше всех уникальных цифр
        int minCountOfUnicNumber = countOfUnicNumber[0];
        int indexOfMinCountUnicNumber = 0;
        for (int i = 1; i < countOfUnicNumber.length; i++) {
            if(countOfUnicNumber[i]<minCountOfUnicNumber){
                minCountOfUnicNumber = countOfUnicNumber[i];
                indexOfMinCountUnicNumber = i;
            }
        }
        System.out.println(args[indexOfMinCountUnicNumber]);
    }
}
