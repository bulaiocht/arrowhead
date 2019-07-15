package generics.erasure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SomeType<T> {

    private T type;

    public <E> void consume(Collection<E> collection) {
        System.out.println("collection consumed");
        Iterator<E> iterator = collection.iterator();

        while (iterator.hasNext()) {
            E next = iterator.next();
            System.out.println(next);
        }

    }

    public void consume(List<Integer> list) {
        Integer integer = list.get(0);
        System.out.println("integer list consumed: " + integer);
    }

}
