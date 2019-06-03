package home_tasks.tasks1;

public class Test {
    public static void main(String[] args) {
        int number = 12345789;

        while (number > 0) {
            System.out.println( number % 10);
            number = number / 10;
        }
    }
}
