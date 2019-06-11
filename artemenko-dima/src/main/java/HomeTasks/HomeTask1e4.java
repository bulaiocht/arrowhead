package HomeTasks;

public class HomeTask1e4 {
//    4. Определить является ли введенное число палиндромом: его значение
//    задом наперед будет таким же (например: 131, 17155171, 12121)
    public static void main(String[] args) {
        for (String number : args)
            check(number);
    }

    public static void check(String aString) {
        System.out.print(aString + ": ");
        char[] chars = aString.toCharArray();
        for (int i = 0, j = (chars.length - 1); i < (chars.length / 2); i++, j--) {
            if (chars[i] != chars[j]) {
                System.out.println("Not a palindrome!");
                return;
            }
        }
        System.out.println("Found a palindrome!");
    }
}
