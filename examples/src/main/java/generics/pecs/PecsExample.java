package generics.pecs;

import generics.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class PecsExample {
    public static void main(String[] args) {

        List<? extends Integer> producer = new ArrayList<>();

        //producer.add(10);//Not ok

        Integer integer = producer.get(0);//OK

        List<? super Number> consumer = new ArrayList<>();

        //Number number1 = consumer.get(0);//Not ok

        consumer.add(10);
        consumer.add(10L);

        List<GenericBox<? extends Number>> boxList = new ArrayList<>();

        GenericBox<Integer> integerGenericBox = new GenericBox<>();
        GenericBox<Number> numberGenericBox = new GenericBox<>();
        GenericBox<String> stringGenericBox = new GenericBox<>();

        boxList.add(integerGenericBox);
        boxList.add(numberGenericBox);
        //boxList.add(stringGenericBox);//not ok

        GenericBox<? extends Number> resultBox = boxList.get(0);

        Number element = resultBox.getElement();
        //resultBox.setElement(10);//not Ok


        List<GenericBox<? super Number>> boxes = new ArrayList<>();

        //boxes.add(integerGenericBox); //Not ok
        boxes.add(numberGenericBox);
        //boxes.add(stringGenericBox); //Not ok

        GenericBox<? super Number> genericBox = boxes.get(1);
        genericBox.setElement(10);
        genericBox.setElement(10L);
        genericBox.setElement(10.0F);
        //genericBox.setElement("Hello"); //Not ok

    }
}
