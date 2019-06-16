package exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExceptionRunner {

    public static void main(String[] args) {

        try {

            exceptionThrower();

            try {

                multipleExceptionThrower();

            } catch (IOException | IllegalArgumentException | ArithmeticException e) {

                System.out.println("Kill all resources");

            } finally {

                System.out.println("This is finally block");

            }

        } catch (RuntimeException e){
            System.out.println("Status 500 internal server error: " + e.getMessage());
        }
    }

    private static void exceptionThrower() {

        try {

            Files.readAllLines(Paths.get("examples/src/main/resources/song.txt"))
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private static void multipleExceptionThrower() throws IOException {

//        if (Math.random() > 0.7) {
//            throw new IllegalArgumentException();
//        }
//
//        if (Math.random() > 0.4) {
//            throw new IOException();
//        }
//
    }

}
