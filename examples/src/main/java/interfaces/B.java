package interfaces;

public interface B {

    int NUMBER = 42;

    default void def() {
        System.out.println("B def");
    }

}
