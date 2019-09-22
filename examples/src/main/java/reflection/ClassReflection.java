package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.function.Function;

public class ClassReflection {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {

        SimpleFileReader reader = new SimpleFileReader();

        SimpleService service = new SimpleService(reader);

//        service.doSomething();

        Class<SimpleService> simpleServiceClass = SimpleService.class;

        Class<Integer> integerClass = int.class;

//        System.out.println(integerClass.isPrimitive());

//        Class<Integer> integerClass = int.class;
//
//        Class<Void> voidClass = void.class;
//
//        Class<int[]> aClass = int[].class;
//
//        Class<int[][]> aClass1 = int[][].class;
//
//
//        Class<? extends SimpleService> aClass2 = service.getClass();
//
//        Class<?> aClass3 = Class.forName("reflection.SimpleService");
//

//        System.out.println(simpleServiceClass.isPrimitive());

//        Class<?>[] interfaces = simpleServiceClass.getInterfaces();
//
//        for (Class<?> i : interfaces) {
//            System.out.println(i.getName());
//            for (final Method method : i.getMethods()) {
//                System.out.println(method.getName());
//
//                Class<?>[] parameterTypes = method.getParameterTypes();
//                for (final Class<?> parameterType : parameterTypes) {
//                    System.out.println(parameterType.getName());
//                }
//
//                System.out.println(method.isSynthetic());
//
//            }
//        }

//        Function<String, Integer> function = s -> {
//            System.out.println(s);
//            return s.length();
//        };
//
//        Class<? extends Function> funClass = function.getClass();
//
//        System.out.println(funClass.isSynthetic());
//
//        Method[] declaredMethods = funClass.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//            int modifiers = declaredMethod.getModifiers();
//            if (Modifier.isPublic(modifiers)) {
//                System.out.print("public ");
//                Class<?> returnType = declaredMethod.getReturnType();
//                System.out.print(returnType.getName() + " ");
//                System.out.print(declaredMethod.getName());
//                System.out.print("(");
//                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
//                for (final Class<?> parameterType : parameterTypes) {
//                    System.out.println(parameterType.getName());
//                }
//            }
//            declaredMethod.invoke(function, "Hello");
//
//        }







//        for (final Method method : simpleServiceClass.getDeclaredMethods()) {
//
//
//
//            if ("doStuff".equals(method.getName())){
//
//                method.setAccessible(true);
//                method.invoke(service, new Object[]{"Hello"});
//
//            }
//
//            if ("secretMethod".equals(method.getName())){
//                method.setAccessible(true);
//                method.invoke(service);
//            }
//


        Class<SingleObject> singleObjectClass = SingleObject.class;
        Constructor<?>[] constructors = singleObjectClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            SingleObject object = (SingleObject)constructor.newInstance("Private constructor says hello");
            System.out.println(object.getField());
        }

        String[] array = (String[])Array.newInstance(String.class, 10);
        System.out.println(array.length);




    }

}
