package generics;

public class GenericBox<E> {

    private E element;

    public E getElement() {
        return element;
    }

    public void setElement(final E element) {
        this.element = element;
    }

}
