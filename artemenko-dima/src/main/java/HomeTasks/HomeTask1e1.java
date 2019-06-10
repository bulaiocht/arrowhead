package HomeTasks;

public class HomeTask1e1 {
//    1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    public static void main (String [] args){

        int min = 10, max = 0;
        String minStr = null, maxStr = null;

        for (String num : args) {
            System.out.println(num);
            if (num.length() < min) {
                min = num.length();
                minStr = num;
            }
            if (num.length() > max) {
                max = num.length();
                maxStr = num;
            }
        }
        System.out.println("the shortest number " + minStr + " number length: " + min + "\n" +
                "the longest number " + maxStr + " number length: " + max );
    }
}
