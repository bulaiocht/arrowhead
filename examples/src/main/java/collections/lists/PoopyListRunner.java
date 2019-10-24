package collections.lists;

import java.util.Iterator;

public class PoopyListRunner {

    public static void main(String[] args) {

        SlowPoopyList<String> strings = new SlowPoopyList<>();

        strings.add("One");
        strings.add("Two");
        strings.add("Three");
        strings.add("Four");

        System.out.println(strings.size());

        Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()) {

            strings.add("");
            System.out.println(iterator.next());

        }
    }
}
