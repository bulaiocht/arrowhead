package reference.shading;

public class FieldHolder {

    static String name = FieldHolder.class.getSimpleName();

    protected String field = "I'm a field";

    private int privateField;

    public FieldHolder() {
        System.out.println(name);
        System.out.println(field);
    }
}
