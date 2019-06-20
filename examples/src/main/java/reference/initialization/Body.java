package reference.initialization;

import java.io.IOException;
import java.io.Serializable;

//Class declaration
public class Body extends BodyParent implements Serializable {

    //instance variable
    private int instanceVar;

    //class variable
    private static int classVar = 1;

    //Initializer
    {

        System.out.printf("Super is already available and not null: %s\n", super.equals(this));
        System.out.println("First initializer.");
        System.out.printf("Instance var before initializer: %d\n", this.instanceVar);
        this.instanceVar = 8;
        System.out.printf("Instance var after initializer: %d\n", this.instanceVar);
        System.out.println();

    }

    //Static initializer
    static {

        System.out.println("First static initializer.");
        System.out.printf("Class var before initializer: %d\n", classVar);
        classVar = 9;
        System.out.printf("Class var after initializer: %d\n", classVar);
        System.out.println();

    }

    //Default constructor
    public Body() {
        super();
        System.out.printf("Constructor of: %s\n", Body.class.getSimpleName());
        System.out.printf("Constructor. Instance var before constructor: %d\n", this.instanceVar);
        this.instanceVar = 7;
        System.out.printf("Constructor. Instance var after constructor: %d\n", this.instanceVar);
        System.out.println();
    }


    //initializer
    {
        System.out.println("Second initializer.");
        System.out.printf("Instance var before initializer: %d\n", this.instanceVar);
        this.instanceVar = 11;
        System.out.printf("Instance var after initializer: %d\n", this.instanceVar);
        System.out.println();
    }

    //static initializer
    static {
        System.out.println("Second static initializer.");
        System.out.printf("Class var before initializer: %d\n", classVar);
        classVar = 11;
        System.out.printf("Class var after initializer: %d\n", classVar);
        System.out.println();
    }


    public static int bodyMethod(String var) throws IOException {
        return var.length();
    }

    public final int nonStaticMethod() {
        super.parent();
        final int instanceVar = this.instanceVar;
        return instanceVar;
    }

    public void shader(int instanceVar) {

        this.instanceVar = instanceVar;

    }

    public void shader() {

    }

    public void shader(int var1, int var2) {}

    public void shader(double var2, int var1) {}

    public void shader(int var2, double var1) {}



}
