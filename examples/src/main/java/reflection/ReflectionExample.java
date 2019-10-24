package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.Function;

public class ReflectionExample {

    public static void main(String[] args) {

        MyInterface myInterface = System.out::println;

        MyInterface mi = (MyInterface) Proxy.newProxyInstance(ReflectionExample.class.getClassLoader(), new Class[]{MyInterface.class}, new MyHandler(myInterface));

        mi.doThings("hello");


    }

    private static class MyHandler implements InvocationHandler {

        private Object target;

        public MyHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Class<?> aClass = target.getClass();
            Method declaredMethod = aClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
            System.out.println("invoking method of proxy");
            Object invoke = declaredMethod.invoke(target, args);
            System.out.println("invoked method of proxy");
            return invoke;
        }
    }

    interface MyInterface {

        void doThings(String arg);

    }

}
