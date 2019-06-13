package abstracts;

public class AbstractRunner {
    public static void main(String[] args) {

        AbstractParent parent = new RealChild();
        parent.abstractMethod();
        parent.realMethod();

        AbstractParent another = new AbstractParent() {
            @Override
            public void abstractMethod() {
                System.out.println("I'm a realization too");
            }
        };

        another.abstractMethod();

    }
}
