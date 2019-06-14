package inner;

public class InnerNestedExampleChild extends InnerNestedExample implements InnerNestedExample.NestedInterface {

    @Override
    public void doStuff() {

    }

    public class InnerClassChild extends InnerNestedExample.InnerClass implements InnerNestedExample.NestedInterface{

        @Override
        public String getParentField() {

            return super.getParentField();
        }

        @Override
        public void doStuff() {

        }
    }

}
