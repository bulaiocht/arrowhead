package generics.wildcard;

public class Box<T> {

    private T value;

    public T get() {
        return value;
    }

    public void put(T value) {
        this.value = value;
    }
}
