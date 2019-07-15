package generics.wildcard2;

public interface IBox<T> {

    T get();

    void put(T element);

    void put(IBox<? extends T> box);

    boolean containsSameElement(IBox<? extends T> box, EqualityComparator<? super T> comparator);

}

