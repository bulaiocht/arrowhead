package reference.modifiers.one;

public class Child extends Parent {

    public Child() {
        super();
    }

    public Child(String var) {
//        super(var);
    }

    public Child(String var1, String var2) {
        super(var1, var2);
    }

    public Child(final String s1, final String s2, final String s3) {
        super(s1, s2, s3);
    }

    public void callerMethod() {
        protectedMethod();
        int f = protectedField;

    }

    @Override
    protected int protectedMethod() {
        return super.protectedMethod();
    }

}
