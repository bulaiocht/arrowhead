package reference.initialization;

public class BodyParent extends BodyGrandParent {

    private static int parentClassVar = 666;

    static {
        System.out.println("First static parent initializer.");
        System.out.printf("Class var before initializer: %d\n", parentClassVar);
        parentClassVar = 667;
        System.out.printf("Class var after initializer: %d\n", parentClassVar);
        System.out.println();

    }

    public BodyParent() {
        super();
        System.out.printf("Constructor of: %s\n\n", BodyParent.class.getSimpleName());
    }

    public void parent() {}
}
