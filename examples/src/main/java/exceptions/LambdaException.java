package exceptions;

import reference.object.ObjectChild;

import java.io.IOException;
import java.util.function.Function;

public class LambdaException {

    public static void main(String[] args) throws IOException{

        Function function = o -> {
            try {
                return ex();
            } catch (IOException e) {
                e.printStackTrace();
                return 10;
            }
        };

        Function f = new Function() {
            @Override
            public Object apply(final Object o) {
                try {
                    return ex();
                } catch (IOException e) {
                    e.printStackTrace();
                    return 10;
                }
            }
        };

    }

    public static Integer ex() throws IOException {
        throw new IOException();
    }

}
