package reference.modifiers.one;

public class Parent {

    public Parent() {
    }

    private Parent(String string) {
    }

    protected Parent(String s1, String s2){
    }

    Parent(String s1, String s2, String s3) {
    }

    public int publicField = 3;
    private int privateField = 10;
    protected int protectedField = 12;
    int defaultField = 11;

    private void privateMethod() {
        System.out.println("private");
    }

    protected int protectedMethod() {
       return protectedField;
    }

    int defaultMethod() {
        return defaultField;
    }

}
