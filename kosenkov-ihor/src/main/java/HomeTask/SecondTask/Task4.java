package HomeTask.SecondTask;

public class Task4 {

    public static void main(String[] args) {

        System.out.printf("%s %s палиндромом", args[0], isPalindrome(args[0]) ? "является" : "не является");

    }

    public static boolean isPalindrome(String number){
        String numberReverse = new StringBuilder(number).reverse().toString();
        return number.equals(numberReverse) ? true :false;
    }

}
