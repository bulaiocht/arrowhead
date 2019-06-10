package interfaces;

public interface A extends B, C, D{

    void method();

    static void staticMethod() {

    }

    @Override
    default void def() {
        C.super.def();
    }
}
