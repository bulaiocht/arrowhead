package generics.gentypes;

public class NumberBox<T extends Number> {

    private T number;

    public T getNumber() {
        return number;
    }

    public void setNumber(final T number) {
        this.number = number;
    }

}
