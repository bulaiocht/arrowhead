package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

public class CollectionsRunner {

    public static void main(String[] args) {

        listExample();



    }

    private static void setExample() {

        Set<String> set = new HashSet<>();

    }

    private static void listExample() {
        ArrayList<String> strings = new ArrayList<>(250);
        strings.add(10, "hello");
        strings.add(null);
        strings.add("hello");
        strings.add("hello");

        ListIterator<String> stringListIterator = strings.listIterator();

        while (stringListIterator.hasNext()) {
            System.out.println(stringListIterator.next());
            stringListIterator.remove();
        }

        System.out.println(strings);
    }

}
