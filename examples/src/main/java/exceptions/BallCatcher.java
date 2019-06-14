package exceptions;

import java.io.IOException;

public class BallCatcher {

    public static void main(String[] args) {

        int counter = 0;

        while (true) {

            if (counter % 4 == 3 ) {

                try {

                    throw new Ball();

                } catch (Ball ball) {

                    System.out.println("Ball caught");
                    counter = 0;

                } catch (IllegalArgumentException e ) {

                }
            }

            counter++;

        }

    }

}
