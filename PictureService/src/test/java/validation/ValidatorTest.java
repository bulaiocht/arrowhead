package validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    final private String CORRECT_CONTENT_TYPE = "image/jpg";
    final private String INCORRECT_CONTENT_TYPE = "/html";
    final private long LESS_THAN_MAX = 30;
    final private long MORE_THAN_MAX = 305;
    final private Validator testValidator = new Validator();

    @Test
    void whenCheckMaxSizeReturnTrueTest() {

        Assertions.assertTrue(testValidator.checkMaxSize(LESS_THAN_MAX));
    }

    @Test
    void whenCheckMaxSizeReturnFalseTest() {
        Assertions.assertFalse(testValidator.checkMaxSize(MORE_THAN_MAX));
    }

    @Test
    void whenCheckImageReturnTrue() {
        Assertions.assertTrue(testValidator.checkImage(CORRECT_CONTENT_TYPE));
    }

    @Test
    void whenCheckImageReturnFalse() {
        Assertions.assertFalse(testValidator.checkImage(INCORRECT_CONTENT_TYPE));
    }
}