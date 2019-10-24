package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SomeUtil<E> {

    public <T extends Person> void take(List<T> list) {

        for (T t : list) {
            System.out.println(t);
        }

    }

    public <U extends Person & Serializable & Comparable<Person> & Cloneable> void compute(List<U> list) {

    }

    public void compute(ArrayList<? extends Person> list) {

        Person person = list.get(0);// this is erasure of '? extends Person'

        // no guarantees that this is valid operation, because '?' might be of type User
        // you cannot do User u = new Person();
        // list.add(new Person());

    }

}
