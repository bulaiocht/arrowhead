package lesson_4;

public class BallCatch {
    public static void main(String[] args) {
        int counter = 0;
        while (true) {
            if (counter % 4 == 3) {
                try {
                    throw new Ball();
                } catch (Ball ball) {
                    System.out.println("Ball catch");
                    counter=0;
                }
            }
            counter++;
        }

    }

}
