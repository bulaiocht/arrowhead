package basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrimitiveExample {

    private static final Logger log = LoggerFactory.getLogger(PrimitiveExample.class);

    public void integerOperations() {

        int a = +3;

        int b = -a;

        long l = 5;

        byte b1 = +127;

        final int i = Byte.toUnsignedInt((byte) -7);
        final long l1 = Byte.toUnsignedLong((byte) -7);

        log.info("unsigned int: {}", i);
        log.info("unsigned long: {}", l1);

        //Compilation error.
        //All calculations are in 32 bit.
        //byte b2 = -b1;

        //Compilation error.
        //Second operand is long, so all calculations are in 64 bit
        //a = a + l;


    }
}
