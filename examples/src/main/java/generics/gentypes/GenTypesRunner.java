package generics.gentypes;

import generics.ClassicBox;
import generics.GenericBox;
import generics.Pair;

import java.util.ArrayList;
import java.util.List;

public class GenTypesRunner {
    public static void main(String[] args) {

        ClassicBox box = new ClassicBox();
        box.setElement("hello");
        String content = (String) box.getElement();
        System.out.println(content);

        box.setElement(1); //No CE
//        String wrong = (String) box.getElement(); //No warnings no CE. ClassCastException at runtime
//        System.out.println(wrong);

        List list; //Raw list
        ArrayList<String> strings = new ArrayList<>(); //Generified list
        list = strings; //Ok
        list.add(10); //OK

        String word = strings.get(0);// ClassCastException


        GenericBox<String> genericBox = new GenericBox<>();
        genericBox.setElement("hi");
        //genericBox.setElement(new Object()); CE
        String element = genericBox.getElement();
        System.out.println(element);

        //Raw generic box
        GenericBox rawBox = new GenericBox();
        rawBox.setElement(1); //warning
        Integer someNum = (Integer) rawBox.getElement();
        System.out.println(someNum);

        //Multiple parameters
        Pair<String, Integer> pair = new Pair<>("hello", 10);
        String key = pair.getKey();
        Integer value = pair.getValue();

        //Parameterized types
        GenericBox<Integer> integerGenericBox = new GenericBox<>();
        Pair<String, GenericBox<Integer>> complexPair = new Pair<>("Hello", integerGenericBox);

        Integer integer = complexPair.getValue().getElement();

        System.out.println(integer);

    }
}
