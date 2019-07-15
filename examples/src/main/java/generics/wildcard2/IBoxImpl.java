package generics.wildcard2;

import generics.wildcard.Box;

public class IBoxImpl<T> implements IBox<T> {

    private T element;

    public IBoxImpl(T element) {
        this.element = element;
    }

    @Override
    public T get() {
        return this.element;
    }

    @Override
    public void put(final T element) {
        this.element = element;
    }

    @Override
    public void put(final IBox<? extends T> box) {
        this.element = box.get();
    }

    @Override
    public boolean containsSameElement(final IBox<? extends T> box, final EqualityComparator<? super T> comparator) {
        return false;
    }


}
