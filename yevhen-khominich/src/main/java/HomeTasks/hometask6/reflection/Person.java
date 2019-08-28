package HomeTasks.hometask6.reflection;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.stream.Stream;

public class Person implements ICheckAge, Runnable {

    public int age = 18;
    private String name;
    private float cash;

    private Person(String name) {
        this.name = name;
    }

    public Person() {

    }


    public String getName() {
        return name;
    }


    @Override
    public void run() {
        System.out.println("running");
    }

    @SomeAnnotation
    public void AnnotationMethod() throws InterruptedException{
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1);
            Person person = new Person();
        }

    }

    @SomeAnnotation
    public void pubMethod() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("I am public method");
    }

    private String privMethod(int n) {

        return null;
    }

    @Override
    public boolean oldEnough(int age) {
        if (age >= 18) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
