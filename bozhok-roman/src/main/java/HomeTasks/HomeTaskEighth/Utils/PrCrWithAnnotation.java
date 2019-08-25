package HomeTasks.HomeTaskEighth.Utils;

import HomeTasks.HomeTaskEighth.ProxyTester.ProxyWithAnnot.PWAAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PrCrWithAnnotation {
    public static <T extends I ,I>  I getProxy (T obj ,Class<I> cls,Class<?extends Annotation> ant, I intf){
        Handler<T> handler = new Handler<>(obj,ant);


        I o = (I) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, handler);

        return o;
    }

    private static class Handler<T> implements InvocationHandler {
        private T org;
        private Class<?extends Annotation> ant;

        public Handler(T org,Class<?extends Annotation> ant) {
            this.ant = ant;
            this.org = org;
        }

        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            long timer ;
            Class<?> declaringClass = method.getDeclaringClass();

            Method[] declaredMethods = org.getClass().getDeclaredMethods();


            for (Class<?> interf : org.getClass().getInterfaces()) {
                if (declaringClass.isAssignableFrom(interf)) {
                    for (Method declaredMethod : declaredMethods) {

                        if (declaredMethod.getName().equals(method.getName())&&
                                declaredMethod.isAnnotationPresent(ant)) {

                            try {
                                long start = System.nanoTime();
                                Object invoke = method.invoke(org, objects);
                                timer = System.nanoTime() - start;
                                System.out.println("Method: " + method.getName() + "\n"
                                        + "Time: " + timer+" nanoSec");
                                return invoke;
                            } catch (InvocationTargetException e) {
                                throw e.getTargetException();
                            }
                        }
                    }

                }
            }

            return null;
        }
    }
}
