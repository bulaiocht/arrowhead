import basics.PrimitiveExample;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class PrimitiveTest {

    private static final Logger log = LoggerFactory.getLogger(PrimitiveTest.class);

    private static PrimitiveExample example;

    @BeforeClass
    public static void init() {
        example = new PrimitiveExample();
    }

    @Test
    public void primitives() {

        final Object object = new Object();
        example.integerOperations();

        String string = Integer.toBinaryString(0xff);

        log.info(string);

    }

    @Test
    public void ternary() {

        boolean b = false;

        b = 2 > 3 ? true : false;

    }

    @Test
    public void floatingPoint() {

        String something = "";

        float nan = 0.0f/0.0f;
        log.info("NaN: {}", nan);
        log.info("{}", nan == 0.0f);
        log.info("{}", nan > 0.0f);
        log.info("{}", nan < 0.0f);
        log.info("{}", nan == Float.POSITIVE_INFINITY);
        log.info("{}", nan == Float.NEGATIVE_INFINITY);
        log.info("{}", nan == nan);
        log.info("{}", Float.isNaN(nan));

        log.info("Max: {}", Float.MAX_VALUE);
    }

    @Test
    public void precisionLoss() {

        double d1 = 0.1;
        double d2 = 0.2;
        double d3 = 0.3;

        log.info("0.1: {}", Long.toBinaryString(Double.doubleToRawLongBits(d1)));
        log.info("0.2: {}", Long.toBinaryString(Double.doubleToRawLongBits(d2)));
        log.info("0.3: {}", Long.toBinaryString(Double.doubleToRawLongBits(d3)));

        assertThat(d3, is(not(d1 + d2)));

        Assertions.assertThat(d3).isNotEqualTo(d1 + d2);

    }

    @Test
    public void castingPrecisionLoss() {

        long l2 = 1111111111111111111L;
        double d2 = l2;
        l2 = (long) d2;

        log.info("{}", d2);
        log.info("{}", l2);

        Assertions.assertThat(l2).isNotEqualTo(d2);

    }

    @Test
    public void floatingPointStandard() {
        float fPos = 17e8f;
        float fNeg = -17e8f;
        log.info("{}: {}", fPos, Long.toBinaryString(Float.floatToRawIntBits(fPos)));
        log.info("{}: {}", fNeg, Long.toBinaryString(Float.floatToRawIntBits(fNeg)));

        int unsignedInt = Byte.toUnsignedInt((byte) 0b11111111);
        log.info("{}", unsignedInt);
        log.info(String.valueOf(255-127));
    }
}

