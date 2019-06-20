package abstracts;

public class RealChild extends AbstractParent {

    @Override
    public void abstractMethod() {
        System.out.println("Implementation");
        System.out.println(COMMON_FIELD);
    }


}
