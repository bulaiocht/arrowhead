package reference.modifiers.one;

public class ModifierExample {

    public static void main(String[] args) {

        Parent parent = new Parent();
//        Parent parent1 = new Parent("");
        Parent parent2 = new Parent("", "");
        Parent parent3 = new Parent("", "", "");

        int defField = parent.defaultField;
        int protField = parent.protectedField;
        parent.defaultMethod();
        parent.protectedMethod();

        Child child = new Child();

        int defaultField = child.defaultField;
        int protectedField = child.protectedField;

        child.defaultMethod();
        child.protectedMethod();

    }

}
