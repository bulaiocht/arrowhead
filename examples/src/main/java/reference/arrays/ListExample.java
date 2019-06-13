package reference.arrays;

import java.util.ArrayList;

public class ListExample {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        for (Integer integer : list) {
            System.out.printf(" %d ", integer);
        }

    }

}
