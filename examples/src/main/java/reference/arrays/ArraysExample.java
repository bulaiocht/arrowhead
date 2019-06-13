package reference.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysExample {

    public static void main(String[] args) {

        int [] empty1 = new int [] {};

        System.out.println(empty1.length);

        int[] clone = empty1.clone();

        System.out.println(Arrays.toString(clone));

        System.out.println(clone == empty1);

        int [] empty2 = new int [0];

        int [] def1 = new int [10]; //zeroes

        int [] def2 = new int []{0,0,0,0,0,0,0,0,0,0}; //zeroes

        int [][] matrix = new int[5][5];

        int [][] arrayOfArrays = new int[][]{{1},{1}};

        int [][][] arrayOfArraysOfArrays = new int[][][]{{{10}},{{10}},{{10}}};

        int [][][][][][] sixCrazy = new int[2][1][1][1][1][1];

        for (int e : def1) {
            System.out.printf(" %d ", e);
        }

        for (int i = 0; i < def1.length; i++) {

        }

    }
}
