import basics.LexemeExample;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LexemeTest {

    private static final Logger log = LoggerFactory.getLogger(LexemeTest.class);

    @Test
    public void callLexemeMethodsTest() {
        LexemeExample example = new LexemeExample();
        example.callWeirdMethod();
    }

    @Test
    public void namingAndLiterals() {

        //This code will not be supported in Java SE 9+
        String _ = "underscore";

        int _a = 22;

        int b_ = 2;

        int $c = 3;

        //special symbols are prohibited
        //!@#%^&*()-=+~`'" and so on

        int binary = 0b0_10_01_01001_111;

        int hex = 0xD_a_d_a_C_a_f_e;

        long longHex = 0xADEL;

        int octal = 0_7_6_5_4_3_2_1_0;

        float floatLit1 = 1.2345f;
        float floatLit2 = .12345e+1F;
        float floatLit3 = 123.45e-2f;

        float floatLitHex = 0xAbc.CACp-2f;

        double doubleLit1 = 1.2345;
        double doubleLit2 = 1.2345d;
        double doubleLit3 = .12345e+0D;
        double doubleLit4 = 12.345e-1d;

        double doubleLitHex = 0xAbc.CACp-2d;

    }
}
