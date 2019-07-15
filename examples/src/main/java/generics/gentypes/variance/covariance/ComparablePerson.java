package generics.gentypes.variance.covariance;

public class ComparablePerson implements Comparable {

    String name;

    int age;

    public ComparablePerson(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        ComparablePerson person = (ComparablePerson) o;
        return Integer.compare(age, person.age);
    }
}
