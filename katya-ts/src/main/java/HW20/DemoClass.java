package HW20;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class DemoClass {

    public static void main(String[] args) throws Exception {
        TestClass obj = new TestClass();
        Class clss = obj.getClass();
        System.out.println("The name of the class is " + clss.getName());

        Constructor constructor = clss.getConstructor();
        System.out.println("The name of constructor is " + constructor.getName());
        System.out.println("Public methods of class are:");

        Method[] methods = clss.getMethods();

        for (Method method : methods)
            System.out.println(method.getName());

        Method callRunMethod = clss.getDeclaredMethod("run");
        callRunMethod.invoke(obj);

        Field field = clss.getDeclaredField("s");
        field.setAccessible(true);
        field.set(obj, "is it me you're looking for?");
        Method callFirstMethod = clss.getDeclaredMethod("firstMethod");
        callFirstMethod.invoke(obj);

        Method callSecondMethod = clss.getDeclaredMethod("secondMethod", int.class);
        callSecondMethod.invoke(obj, 2);

        Method callThirdMethod = clss.getDeclaredMethod("thirdMethod");
        callThirdMethod.setAccessible(true);
        callThirdMethod.invoke(obj);
    }
}