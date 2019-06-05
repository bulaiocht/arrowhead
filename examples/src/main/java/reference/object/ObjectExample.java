package reference.object;

import java.util.Arrays;

public class ObjectExample {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {

        Object object = new Object();

        Class<?> clazz = object.getClass();

        final Class<Void> voidClass = void.class;

        final Class<Integer> integerClass = int.class;

        boolean equals = object.equals(object);

        int hashCode = object.hashCode();

        String string = object.toString();

//        object.notify();
//
//        object.notifyAll();
//
//        object.wait();

        //Joshua Bloch suggest not using clone() for your objects
        ObjectChild child = new ObjectChild();

        ObjectChild clone = (ObjectChild) child.clone();

        System.out.println(child);
        System.out.println(clone);

        System.out.printf("object == clone: %s\n", child == clone);
        System.out.printf("object.equals(clone): %s\n", child.equals(clone));
        System.out.println(child.hashCode());
        System.out.println(clone.hashCode());

        //clone() works fast with arrays.
        int [] array = new int[]{1,2,3,4,5,6,7,8,9};

        int[] arrayClone = array.clone();

        System.out.printf("array: %s\n", Arrays.toString(array));
        System.out.printf("array clone: %s\n", Arrays.toString(arrayClone));
        System.out.printf("array == clone: %s\n", array == arrayClone);

    }
}
