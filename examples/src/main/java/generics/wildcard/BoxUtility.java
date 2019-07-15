package generics.wildcard;

import generics.Person;
import generics.User;

import java.io.Serializable;

public class BoxUtility {

    public static void copy(Box<? extends User> src, Box<? super User> dest) {

        User user = src.get();

        dest.put(user);

    }

    public static void unbox(Box<?> any) {

        //Only Object available.
        //It know that ? is some T for unknown T
        //it returns erasure of T which is Object
        Object object = any.get();

        //you can't put anything, even object
//        any.put(object);

        //Only null is allowed
        any.put(null);

        System.out.println(object);
    }

    public static void rebox(Box<?> any) {

//        any.put(any.get());
        reboxHelper(any);

    }

    public static <T> void reboxHelper(Box<T> box) {
        box.put(box.get());
    }

}
