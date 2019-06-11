package HomeTasks.HomeTaskSecond;

public class Palindrome {
    public static void main(String[] args) {
        palindrome(args);

    }
    private static void palindrome (String[]args){
        String so = args[0];
        String s1 = new StringBuilder(so).reverse().toString();
        System.out.println(s1.equals(so)? so+" - palindorme": so+" - no palondrome");

    }
}
