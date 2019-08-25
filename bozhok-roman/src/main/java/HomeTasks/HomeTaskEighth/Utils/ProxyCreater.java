package HomeTasks.HomeTaskEighth.Utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyCreater {
    public static <T extends I ,I>  I getProxy (T obj ,Class<I> cls, I intf){
        CustomInvocationHandler<T> handler = new CustomInvocationHandler<>(obj);


        I o = (I) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, handler);

        return o;
    }

    private static class CustomInvocationHandler<I> implements InvocationHandler {
        private I org;

        public CustomInvocationHandler(I org) {
            this.org = org;
        }

        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

            Class<?> declaringClass = method.getDeclaringClass();
            for (Class<?> interf : org.getClass().getInterfaces()) {
                if (declaringClass.isAssignableFrom(interf)) {
                    try {
                        return method.invoke(org, objects);
                    } catch (InvocationTargetException e) {
                        throw e.getTargetException();
                    }
                }
            }
            return null;
        }
    }
}
