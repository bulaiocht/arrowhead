import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericTest {

    @Test
    public void name() {
        List<Number> collect = Stream.generate(() -> RandomUtils.nextInt())
                .limit(100)
                .collect(Collectors.toList());

        method(collect);
    }

    private static <T extends Serializable> void method(List<? extends T> list) {
        for (int i = 0; i < list.size(); i++) {
            removeAndPutBack(list, i);
        }
    }

    private static <E> void removeAndPutBack(List<E> list, int index) {
        E remove = list.remove(index);
        list.add(remove);
    }
}
