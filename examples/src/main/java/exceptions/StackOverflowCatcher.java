package exceptions;

public class StackOverflowCatcher {

    static int counter = 0;

    public static void main(String[] args) {

        try {
            rec();
        } catch (Throwable t) {
            System.out.println(counter);
        }

    }

    public static void rec() {
        counter++;
        rec();
    }

}
