package generics.gentypes.variance.covariance;

import java.util.Arrays;

public class CovarianceRunner {

    public static void main(String[] args) {

//        covarianceProblem_1();

        covarianceProblem_2();

    }

    private static void covarianceProblem_1() {
        Number [] numbers = new Integer[10];

        //Integer is Number
        numbers [0] = 1;

        numbers [1] = 2;

        //But Double is Number too
        numbers [2] = 17.5D;

        Object [] objects;

        //Number is Object
        objects = numbers;

        //So is String
        objects [3] = "Apple pie";

        //And array of String
        objects [4] = new String[]{"a", "B"};
    }

    private static void covarianceProblem_2() {
        ComparablePerson[] comparablePeople = new ComparablePerson[] {
                new ComparablePerson("Bill", 25),
                new ComparablePerson("John", 66)};

        Arrays.sort(comparablePeople);

        System.out.println(Arrays.toString(comparablePeople));

        Person[] people = new Person[] {new Person("Mark", 16), new Person("Alice", 58)};

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));
    }

}
