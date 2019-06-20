package reference.object;

public class FinalizeExample {

    public static void main(String[] args) {

        Garbage [] garbage = new Garbage[100];

        for (int i = 0; i < garbage.length; i++) {
            garbage[i] = new Garbage(i);
        }

        while (true){

            for (int i = 0; i < garbage.length; i++) {
                garbage[i] = null;
            }

            System.gc();

            //waiting
        }

    }

}
