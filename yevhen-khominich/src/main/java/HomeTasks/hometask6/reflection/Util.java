package HomeTasks.hometask6.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Util<T> {


    //creation Object, reflection
    public Person createInstance(Class<T> some) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor<?>[] constructors = some.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            Person instance = (Person) constructor.newInstance("Vasya");
            System.out.println(instance.getName());
            return instance;
        }

        return null;
    }

    //creation Object, reflection, method 2
    public Object create(Class<T> some) throws IllegalAccessException, InstantiationException {

        return some.newInstance();
    }

    public Proxy createProxy(int age) {

        Person person = new Person();

        //cast to Proxy
        Proxy e = (Proxy) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                new Class[]{ICheckAge.class},
                new SomeHandler(person));

        //cast to interface
        ICheckAge checkAge = (ICheckAge) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                new Class[]{ICheckAge.class},
                new SomeHandler(person)
        );

        //method of interface
        if (checkAge.oldEnough(age)) {
            System.out.println("Old Enough");
        } else
            System.out.println("Not old Enough !");


        System.out.println("Proxy is created and returned");
        return e;
    }

    public void checkAnotation(Class<T> some) throws Throwable {

        Class<?>[] interfaces = some.getInterfaces();

        Proxy proxy = (Proxy) Proxy.newProxyInstance(
                some.getClassLoader(),
                interfaces,
                new Handler(some.newInstance()));

        proxy.getInvocationHandler(proxy).invoke(proxy, null, null);

    }

    private static class Handler implements InvocationHandler {

        public Handler(Object target) {
            this.target = target;
        }

        private Object target;

        //check Anotations
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            Method[] declaredMethods = target.getClass().getDeclaredMethods();

            for (Method declaredMethod : declaredMethods) {

                Annotation[] annotations = declaredMethod.getAnnotations();
                SomeAnnotation myAnnotation = declaredMethod.getAnnotation(SomeAnnotation.class);

                for (Annotation annotation : annotations) {
                    if (annotation.equals(myAnnotation)) {
                        long time = leadTime(declaredMethod, target);
                        System.out.print(declaredMethod.getName() + " have @SomeAnnotation ");
                        System.out.println("Millis " + time);

                    }
                }

            }

            System.out.println("Proxy is finished");

            return null;
        }

    }

    private static long leadTime(Method method, Object instance) throws Exception {
        long startTime = System.currentTimeMillis();

        method.setAccessible(true);
        //invoke on;y void methods
        method.invoke(instance);

        long stopTime = System.currentTimeMillis();

        return stopTime - startTime;
    }


}
