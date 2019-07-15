package generics.gentypes.variance.invariance;

import generics.GenericBox;

public class InvarianceRunner {

    public static void main(String[] args) {

        GenericBox<Number> numberBox;

        GenericBox<Integer> integerBox = new GenericBox<>();

//        numberBox = integerBox; //CE

    }

}
