package HW20;

public class TestClass implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello, it's me, I was wondering if after all these years you'd like to meet");
    }

    private String s;

    public TestClass() {
        s = "I love you, won't you tell me your name";
    }

    public void firstMethod() {
        System.out.println("Hello, " + s);
    }

    public void secondMethod(int n) {
        System.out.println("Say hello " + n + " heaven, heaven, heaven");
    }

    private void thirdMethod() {
        System.out.println("Can't touch this!");
    }

}