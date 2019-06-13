import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringTest {

    private static final Logger log = LoggerFactory.getLogger(StringTest.class);

    @Test
    public void internTest() {

        String cat1 = "cat";
        String cat2 = new String("cat");
        String cat3 = "cat";

        log.info("{} == {} : {}", cat1, cat3, cat1 == cat3);

        log.info("{} == {} : {}", cat1, cat2, cat1 == cat2);
        log.info("{}.equals({}) : {}", cat1, cat2, cat1.equals(cat2));

        String internedCat2 = cat2.intern();

        log.info("{} == {} : {}", cat1, internedCat2, cat1 == internedCat2);
        log.info("{}.equals({}) : {}", cat1, internedCat2, cat1.equals(internedCat2));

        String concat = internedCat2.concat(cat1);
        log.info(concat);

        concat = concat + 2;
        log.info(concat);

        concat = concat + 2 + 3;
        log.info(concat);

        concat = 2 + 3 + concat;
        log.info(concat);

        //concat = concat + 2 - 1;

    }
}
