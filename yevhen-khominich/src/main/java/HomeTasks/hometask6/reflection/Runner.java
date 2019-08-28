package HomeTasks.hometask6.reflection;

import java.lang.reflect.Proxy;

public class Runner {
    public static void main(String[] args) throws Throwable{
        Util util = new Util<>();
        Person person= new Person();

        util.checkAnotation(Person.class);


    }
}
