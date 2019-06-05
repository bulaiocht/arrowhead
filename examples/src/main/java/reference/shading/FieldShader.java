package reference.shading;

public class FieldShader extends FieldHolder{

    private static String name = FieldShader.class.getSimpleName();

    private String field = "I'm a shade";

    public FieldShader() {
        System.out.println(fieldGetter());
        System.out.println(name);
        System.out.println(FieldHolder.name);
        System.out.println(super.field);
    }

    private String fieldGetter() {
        return field;
    }
}
