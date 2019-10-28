package web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DumbService {

    private String filename;

    public DumbService(String filename) {
        this.filename = filename;
    }

    public long countBig() throws IOException {

        if (filename != null) {

            Path path = Paths.get(filename);

            long count = Files.readAllLines(path).size();

            if (count < 10) {
                throw new IllegalArgumentException("File is too small for me!");
            }

            return count;

        }

        throw new IllegalArgumentException("File should not be null");
    }

}
