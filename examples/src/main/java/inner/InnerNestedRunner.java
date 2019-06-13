package inner;

public class InnerNestedRunner {
    public static void main(String[] args) {


        InnerNestedExample.NestedClass nestedClass = new InnerNestedExample.NestedClass();

        InnerNestedExample.InnerClass innerClass = new InnerNestedExample().new InnerClass();

        innerClass.callPrivateMethod();
        innerClass.getParentField();

        InnerNestedExample example = new InnerNestedExample();
        example.callPrivateInnerClassMethods();

        InnerNestedExample.NestedInterface nestedInterface = new InnerNestedExample().invokeLocalClass();

        nestedInterface.doStuff();

    }
}
