package reference.modifiers.two;

import reference.modifiers.one.Child;
import reference.modifiers.one.Parent;

public class ModifierExampleTwo {

    public static void main(String[] args) {
        Parent parent = new Parent();
//        parent.defaultField;
//        parent.protectedField;

//        Parent parent1 = new Parent("", "");
//        Parent parent2 = new Parent("", "", "");


        Child child = new Child();
        child.callerMethod();
        child.callerMethod();

        Child2 child2 = new Child2();


    }
}
