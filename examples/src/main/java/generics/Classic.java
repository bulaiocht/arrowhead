package generics;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Classic {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        SomeUtil<Object> util = new SomeUtil<>();

        List<User> users = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        util.take(users);
        util.take(people);

//        util.compute(users);
//        util.compute(people);
    }

}
