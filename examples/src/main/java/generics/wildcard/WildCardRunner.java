package generics.wildcard;

import generics.Person;
import generics.User;
import generics.wildcard2.EqualityComparator;
import generics.wildcard2.IBox;
import generics.wildcard2.IBoxImpl;

public class WildCardRunner {
    public static void main(String[] args) {

//        wildCards();


    }

    private static void wildCards() {

        BoxUtility.unbox(new Box<Integer>());
        BoxUtility.unbox(new Box<String>());
        BoxUtility.unbox(new Box<Double>());
        BoxUtility.unbox(new Box<Person>());

        Box<Person> personBox = new Box<>();
        personBox.put(new Person());
        personBox.put(new User());

        Box<User> userBox = new Box<>();
        userBox.put(new User());

        Box<Person> destination = new Box<>();
        Box<Object> objectBox = new Box<>();

        Person person = personBox.get();

        BoxUtility.copy(userBox, userBox);
    }

}
