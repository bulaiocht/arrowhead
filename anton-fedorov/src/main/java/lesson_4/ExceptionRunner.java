package lesson_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ExceptionRunner {
    public static void main(String[] args) {
//        int a = 10 / 0;

        exceptionThrower();
    }

    private static void exceptionThrower() {
        try {

            Files.readAllLines(Paths.get("anton-fedorov/src/resources/song")).forEach(System.out::println);

        } catch (IOException | IllegalArgumentException | ArithmeticException e) {

           throw new RuntimeException(e);

        } finally {

            System.out.println("this is finally block");

        }

    }
}
