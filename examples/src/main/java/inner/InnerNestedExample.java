package inner;

public class InnerNestedExample {

    private String privateName = "My private name";

    private static void privateStaticMethod() {
        System.out.println("Private static parent method");
    }
    private void privateMethod() {
        System.out.println("Private parent method");
    }

    public void callPrivateInnerClassMethods() {

        InnerClass innerClass = new InnerClass();
        innerClass.innerPrivateMethod();
        String name = innerClass.name;

        NestedClass nestedClass = new NestedClass();
        nestedClass.privateNestedMethod();

    }

    public class InnerClass {

        private String name;

        public String getParentField() {
            return privateName;
        }

        public void callPrivateMethod() {
            privateMethod();
        }

        private void innerPrivateMethod() {
            System.out.println("Inner private method");
        }

    }

    public static class NestedClass {

        private void privateNestedMethod() {
            System.out.println("Private nested method");
            privateStaticMethod();
        }

    }

    public interface NestedInterface {

        void doStuff();

    }

    public NestedInterface invokeLocalClass() {

        final class LocalClass implements NestedInterface{

            @Override
            public void doStuff() {
                System.out.println("Doing stuff from local class");
            }
        }

        return new LocalClass();

    }

    public NestedInterface invokeAnonymousLocal() {

        return new NestedInterface() {
            @Override
            public void doStuff() {
                System.out.println("Doing stuff in local anonymous");
            }
        };
    }

}
