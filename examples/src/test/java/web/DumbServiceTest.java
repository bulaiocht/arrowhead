package web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class DumbServiceTest {

    private static final String SRC_PATH = "src/test/resources/";
    private static final String SHORT_FILE = "short_file";
    private static final String LONG_FILE = "long_file";
    private static final String NULL_FILE = null;
    private static final String NONEXISTENT_FILE = "nonexistent";

    private DumbService service;

    @Test
    void countBig_NullFile_WithException() {
        service = new DumbService(NULL_FILE);

        Assertions
                .assertThatThrownBy(() -> service.countBig())
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void countBig_NoFile_IOException() {
        String path = SRC_PATH + NONEXISTENT_FILE;
        service = new DumbService(path);
        Assertions
                .assertThatThrownBy(() -> service.countBig())
                .isInstanceOf(IOException.class);

    }

    @Test
    void countBig_ShortFile_WithException() {
        String path = SRC_PATH + SHORT_FILE;
        service = new DumbService(path);
        Assertions
                .assertThatThrownBy(() -> service.countBig())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countBig_LongFile_Success() throws IOException {

        String path = SRC_PATH + LONG_FILE;
        service = new DumbService(path);
        long number = service.countBig();

        org.junit.jupiter.api.Assertions.assertEquals(number, 10);

        Assertions.assertThat(number).isGreaterThan(9);

        Assertions.assertThat(number).isEqualTo(10);

    }




}
