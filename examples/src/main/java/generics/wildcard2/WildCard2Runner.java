package generics.wildcard2;

import java.util.Collections;

public class WildCard2Runner {

    private static void contrVariance() {

        IBox<Number> nBox = new IBoxImpl<>(2.0);
        IBox<Integer> iBox = new IBoxImpl<>(2);

        nBox.put(2.3);
        nBox.put(2);
        nBox.put(2F);

        nBox.put(iBox);

        EqualityComparator<Object> objectComparator = Object::equals;

        nBox.containsSameElement(iBox, objectComparator);

    }

}
