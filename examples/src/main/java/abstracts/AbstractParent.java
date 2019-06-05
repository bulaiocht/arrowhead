package abstracts;

public abstract class AbstractParent {

    public static final String COMMON_FIELD= "I'm common";

    public abstract void abstractMethod();

    public void realMethod() {
        System.out.println("I'm a real boy!");
    }

}
