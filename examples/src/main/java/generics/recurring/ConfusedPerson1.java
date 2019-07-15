package generics.recurring;

public class ConfusedPerson1 implements Cloneable<ConfusedPerson1> {
    private String name;

    public ConfusedPerson1(final String name) {
        this.name = name;
    }

    @Override
    public ConfusedPerson1 clone() {
        return new ConfusedPerson1(name);
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName();
    }
}
