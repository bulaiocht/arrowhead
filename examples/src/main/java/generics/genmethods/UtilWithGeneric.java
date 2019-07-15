package generics.genmethods;

import generics.GenericBox;
import generics.Pair;

import java.util.Collection;
import java.util.Iterator;

public class UtilWithGeneric {

    public static <K, V> boolean compare(Pair<K, V> first, Pair<K, V> second) {

        return first.getKey().equals(second.getKey()) &&
                first.getValue().equals(second.getValue());

    }

    public static void consume(Collection<? super Integer> collection) {

        Iterator<? super Integer> iterator = collection.iterator();

        for (Object object : collection) {

            System.out.println(object);

        }

    }

    public static <T> void copy (Collection<? extends T> src, Collection<? super T> dst) {

        Iterator<? extends T> iterator = src.iterator();
        while (iterator.hasNext()) {
            final T next = iterator.next();
            dst.add(next);
        }

        Iterator<? super T> iterator1 = dst.iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            System.out.println(next);
        }

    }

    public static void rebox(GenericBox<?> box) {

        //box.setElement(box.getElement()); //It can't do this
        reboxHelper(box);
    }

    private static void reboxBounded(GenericBox<? extends Number> boxed) {
        Number element = boxed.getElement();
        //boxed.setElement(element);//It can't do this

        reboxHelper(boxed);
    }

    private static void reboxUpperBounded(GenericBox<? super Number> box) {
        Object element = box.getElement();
        //box.setElement(element);//It can't do this

        reboxHelper(box);
    }

    private static <V> void reboxHelper(GenericBox<V> box) {
        final V element = box.getElement();
        box.setElement(element);
    }



}
