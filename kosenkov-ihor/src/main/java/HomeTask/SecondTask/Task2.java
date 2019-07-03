package HomeTask.SecondTask;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {

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
            countOfUnicNumber[i] = count;
        }
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
