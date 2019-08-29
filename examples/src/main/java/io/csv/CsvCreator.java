package io.csv;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class CsvCreator {

    private File file;
    private Class<? extends Enum> headerEnum;
    private String [] headers;

    public CsvCreator(File file, Class<? extends Enum> headerEnum) {
        this.file = file;
        this.headerEnum = headerEnum;
        this.headers = createHeaders();
    }

    private String [] createHeaders() {

        String [] headers;

        if (headerEnum != null) {
            Enum[] enumConstants = headerEnum.getEnumConstants();
            headers = new String[enumConstants.length];
            for (int i = 0; i < enumConstants.length; i++) {
                headers[i] = enumConstants[i].toString();
            }
        } else {
            throw new IllegalArgumentException("Headers must not be null");
        }

        return headers;
    }

    private void check(final String[] values) throws IOException {
        if (values == null || values.length == headers.length) {
            throw new IOException("Wrong format!");
        }
    }

    private void append(boolean newRecord, String...values) {
        if (newRecord) {

        }
    }

    private void append(String [] headers, String[] values) {

    }

    private void append(String...values) {

    }
}
