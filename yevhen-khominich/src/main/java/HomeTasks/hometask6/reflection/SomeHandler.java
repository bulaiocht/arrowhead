package HomeTasks.hometask6.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SomeHandler implements InvocationHandler {
    public SomeHandler(Object target) {
        this.target = target;
    }

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Integer arg = (Integer) args[0];
        System.out.println("Person age is " + arg);
        Method[] methods = target.getClass().getDeclaredMethods();
        Object value = null;
        for (Method method1 : methods) {

            if (method1.getName().equals(method.getName())) {
                value = method1.invoke(target, args);
            }
        }

        System.out.println("Proxy is finished");
        return value;

    }
}
