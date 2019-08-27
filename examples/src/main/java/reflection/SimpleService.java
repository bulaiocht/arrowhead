package reflection;

public class SimpleService implements Runnable {

    private SimpleFileReader fileReader;

    public SimpleService(SimpleFileReader fileReader) {
        this.fileReader = fileReader;
    }

    public static final String VALUE = "Constant";


    public void doSomething() {
        System.out.println(fileReader.readFileToString());
    }

    private void doStuff() {
        System.out.println("Hello");
    }

    private void secretMethod() {
        System.out.println("THIS IS ILLEGAL!");
    }

    @Override
    public void run() {
        doSomething();
    }
}
