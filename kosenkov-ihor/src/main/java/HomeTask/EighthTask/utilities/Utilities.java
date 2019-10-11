package HomeTask.EighthTask.utilities;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Utilities {

    public static void printClass(String name) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(name);

        printPackage(aClass);
        System.out.println();

        Class<?> superClass = aClass.getSuperclass();
        String modifiers = Modifier.toString(aClass.getModifiers());
        if (modifiers.length() > 0) {
            System.out.print(modifiers + " ");
        }
        System.out.print("class " + name);
        if (superClass != null && superClass != Object.class) {
            System.out.print(" extends" + superClass.getName());
        }
        System.out.print("\n{\n");
        printField(aClass);
        System.out.println();
        printConstructors(aClass);
        System.out.println();
        printMethods(aClass);
        System.out.println("}");
    }

    private static void printPackage(Class<?> aClass) {
        Package aPackage = aClass.getPackage();
        System.out.println("package " + aPackage.getName() + ";");
    }

    private static<T extends AnnotatedElement> void printAnnotation(T aClass) {
        Annotation[] annotations = aClass.getDeclaredAnnotations();
        if (annotations.length > 0) {
            for (Annotation a : annotations) {
                System.out.println(" " + a);
            }
        }
    }

    private static void printField(Class<?> aClass) {

        Field[] fields = aClass.getDeclaredFields();

        for (Field f : fields) {
            Class<?> type = f.getType();
            String name = f.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    private static void printConstructors(Class<?> aClass) {

        Constructor<?>[] constructors = aClass.getConstructors();

        for (Constructor<?> c : constructors) {
            String name = c.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + " (");
            Class<?>[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    private static void printMethods(Class<?> aClass) {

        Method[] methods = aClass.getDeclaredMethods();

        for (Method m : methods) {
            printAnnotation(m);
            Class<?> retType = m.getReturnType();
            String name = m.getName();

            System.out.print(" ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " " + name + " (");
            Class<?>[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    @Override
    public String toString() {
        return "Utilities{}";
    }
}
