package HomeTasks.hometask6.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintInfo<T> {

    public void printName(Class<T> some) {
        some.getSimpleName();
    }

    public void printInterfaces(Class<T> some) {
        Arrays.stream(some.getInterfaces()).forEach(s -> System.out.println(s.getSimpleName()));
    }

    public void printDeclaredClasses(Class<T> some) {
        Arrays.stream(some.getDeclaredClasses()).forEach(s -> System.out.println(s.getSimpleName()));
    }

    public void printInfoOfMethods(Class<T> some) {
        Method[] declaredMethods = some.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            int modifier = declaredMethod.getModifiers();
            System.out.print(Modifier.toString(modifier)+" ");
            getOtherInfoOfMethod(declaredMethod);
        }
    }



    private void getOtherInfoOfMethod(Method method) {
        Class<?> returnType = method.getReturnType();
        System.out.print(returnType.getSimpleName() + " " + method.getName() + "(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class<?> type : parameterTypes) {
            System.out.print(type.getSimpleName());

        }
        System.out.println(")");
    }

    public void printFields(Class<T> some) {
        Arrays.stream(some.getDeclaredFields()).forEach(s -> System.out.println(s.getName()));
    }

    public void printModifierOfClass(Class<T> some) {
        int modifier = some.getModifiers();

        if (Modifier.isPublic(modifier)) {
            System.out.println("Public");
        } else if (Modifier.isPrivate(modifier))
            System.out.println("Private");
    }

    public void printClasses(Class<T> some) {
        Arrays.stream(some.getClasses()).forEach(s -> s.getName());
    }

    public void printConstructors(Class<T> some) {
        Constructor<?>[] declaredConstructors = some.getDeclaredConstructors();


        for (Constructor<?> constructor : declaredConstructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            int modifier = constructor.getModifiers();

            if (Modifier.isPublic(modifier)) {
                System.out.print("Public ");
            } else if (Modifier.isPrivate(modifier))
                System.out.print("Private ");

            System.out.print("Constructor " + constructor.getName() + " with parameters ");

            for (Class<?> parametr : parameterTypes) {
                System.out.print(parametr.getSimpleName() + " ");
            }
            System.out.println();
        }
    }
}