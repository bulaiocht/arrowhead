package generics.recurring;

import java.io.Serializable;

public class NonRecurringRunner {
    public static void main(String[] args) {

        ConfusedPerson1 person1 = new ConfusedPerson1("Bill");
        ConfusedPerson2 person2 = new ConfusedPerson2("Bob");

        ConfusedPerson1 clone = person1.clone();
        ConfusedPerson2 clone1 = person2.clone();

        clone.clone().clone().clone();

        Cloneable<ConfusedPerson2> iperson = new ConfusedPerson2("Jill");

        //This should be a method
        clone1.clone().clone().clone();

        //Cool
        quadrupleCloning(person2);

        ConfusedPerson2 confusedPerson2 = quadrupleCloning(iperson);
        System.out.println(confusedPerson2);

    }

    //This must be generified
    private static ConfusedPerson2 quadrupleCloning(ConfusedPerson2 person2) {
        return person2.clone().clone().clone().clone();
    }

    private static<T extends Cloneable<T>> T quadrupleCloning(Cloneable<? extends T> cloneable) {
        return cloneable.clone().clone().clone().clone();
    }

    private static <E extends Object & Serializable & java.lang.Cloneable> E someMethod() {
        return null;
    }

}
