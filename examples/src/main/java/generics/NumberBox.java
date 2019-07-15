package generics;

public class NumberBox<E extends Number> {

    E num;

    public E getNum() {
        return num;
    }

    public void setNum(final E num) {
        this.num = num;
    }
}
