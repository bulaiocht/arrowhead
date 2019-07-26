package collections.lists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

public class SlowPoopyList<E> {

    private Link<E> first;
    private int size;
    private int modCount;

    public int size() {
        return this.size;
    }

    public void add(E obj) {

        if (Objects.isNull(first)) {
            first = new Link<>(obj);
            size++;
            modCount++;
            return;
        }

        addLast(obj, first);

    }

    public E remove(E obj) {

        if (Objects.equals(obj, first.element)) {

            E tmp = first.element;
            Link<E> tmpLink = first.next;

            first.element = null;
            first.next = null;
            first = tmpLink;
            size--;
            modCount++;
            return tmp;
        }

        for (Link<E> l = first; l.next != null; l = l.next) {

            Link<E> next = l.next;

            if (Objects.equals(obj, next.element)) {
                Link<E> tmpLink = next.next;
                E tmp = next.element;
                next.next = null;
                next.element =null;
                l.next = tmpLink;
                size--;
                modCount++;
                return tmp;
            }

        }

        return null;

    }

    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
        int counter = 0;

        for (Link<E> l = first; l != null;) {

            if (index == counter){
                return l.element;
            }
            counter++;
            l = l.next;
        }
        return null;
    }

    public void add(E obj, int index) {

        if (index >= size) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }

        insert(0, index, obj, first);
    }

    private void insert(int counter, int index, E obj, Link<E> link) {

        if (counter == index - 1) {
            if (link.next == null) {
                link.next = new Link<>(obj);
                size++;
                return;
            }
            Link<E> l = new Link<>(obj);
            l.next = link.next;
            link.next = l;
            size++;
            modCount++;
            return;
        }

        insert(++counter, index, obj, link.next);
    }

    private void addLast(E obj, Link<E> link) {

        if (link.next == null) {
            link.next = new Link<>(obj);
            size++;
            modCount++;
            return;
        }

        addLast(obj, link.next);
    }

    private static class Link<E> {

        E element;

        Link(E element) {
            this.element = element;
        }

        Link<E> next;

    }

    public Iterator<E> iterator() {


        return new Iterator<E>() {

            int cursor = 0;
            int modC = modCount;

            @Override
            public boolean hasNext() {
                return cursor < size();
            }

            @Override
            public E next() {
                if (modC != modCount)
                    throw new ConcurrentModificationException("Ayaya!");

                return get(cursor++);
            }
        };
    }


}
