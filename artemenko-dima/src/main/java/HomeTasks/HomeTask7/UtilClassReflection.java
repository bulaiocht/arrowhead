package HomeTasks.HomeTask7;

//- напечатать модификаторы доступа класса (public, default),
//- имя класса,
//- интерфейсы, которые он имплементирует, или классы которые он раширяет
//То же относится к полям, конструкторам и к задекларированным методам класса.
//Дополнительно можно напечатать аргументы конструкторов, аргументы и возвращаемые типы методов.
//Создать методы утилитного класса, которые с помощью рефлексии смогут создать:
//- экземпляр класса
//- прокси объекта класса

import HomeTasks.HomeTask7.TestClass.TestClass;
import HomeTasks.HomeTask7.TestClass.TestInterface2;

import java.lang.reflect.*;


public class UtilClassReflection {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class classTest = Class.forName( "HomeTask7.TestClass.TestClass" );

        System.out.println( "Class access modifiers:" );
        System.out.println( getModifiers( classTest.getModifiers() ) );

        System.out.println( "====================\n" +
                "Class name:" );
        System.out.println( classTest.getName() );

        System.out.println( "====================\n" +
                "The interfaces that he implements, or the classes that he expands:" );
        System.out.println( "EXTENDS: " + classTest.getSuperclass() );
        Class[] interfaces = classTest.getInterfaces();
        for (Class cInterface : interfaces) {
            System.out.println( "IMPLEMENTS: " + cInterface.getName() );
        }

        System.out.println( "====================\n" +
                "Class fields:" );
        Field[] publicFields = classTest.getDeclaredFields();
        for (Field field : publicFields) {
            Class fieldT = field.getType();
            System.out.println( "NAME: " + field.getName() +
                    "; TYPE: " + fieldT.getName() +
                    "; MODIFIERS: " + getModifiers( field.getModifiers() ) );
        }

        System.out.println( "====================\n" +
                "Class constructors:" );
        Constructor[] constructors = classTest.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print("TYPES OF PARAMETERS: " + paramType.getName() + " ");
            }
            System.out.println("; MODIFIERS: " + getModifiers( constructor.getModifiers() ) );
        }

        System.out.println( "====================\n" +
                "Class methods:" );
        Method[] methods = classTest.getMethods();
        for (Method method : methods) {
            System.out.print("NAME: " + method.getName() +
                    "; RETURN TYPE: " + method.getReturnType().getName());

            Class[] paramTypes = method.getParameterTypes();
            System.out.print("; TYPES OF PARAMETERS: ");
            for (Class paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println("; MODIFIERS: " + getModifiers( method.getModifiers() ) );
        }

        System.out.println( "====================\n" +
                "Class instance:" );
        classInstance( classTest );


        System.out.println( "====================\n" +
                "Proxy class object:\n" );

        TestClass obj = new TestClass(  );
        TestInterface2 proxyObj = (TestInterface2) Proxy.newProxyInstance( TestClass.class.getClassLoader(),
                new Class[] {TestInterface2.class},
                new LoggingInvocationHandler( obj ));
        System.out.println( proxyObj.method2() );
    }

    private static String getModifiers(int m) {
        String modifiers = "";
        if (Modifier.isPublic( m )) modifiers += "public ";
        if (Modifier.isProtected( m )) modifiers += "protected ";
        if (Modifier.isPrivate( m )) modifiers += "private ";
        if (Modifier.isStatic( m )) modifiers += "static ";
        if (Modifier.isFinal( m )) modifiers += "final ";
        return modifiers;
    }

    private static <T> void classInstance(Class classTest) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Object obj = classTest.newInstance();
        T test = (T) obj;
        System.out.println( test.toString() );
    }

    private static class LoggingInvocationHandler implements InvocationHandler {

        private Object target;

        LoggingInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            Class<?> aClass = target.getClass();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            Object value = null;

            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.isAnnotationPresent( OwnAnnotation.class )){

                    System.out.println( "Method name: " +declaredMethod.getName() );

                    long startTime = System.currentTimeMillis();
                    value = declaredMethod.invoke(target, args);
                    long endTime = System.currentTimeMillis();
                    System.out.println("Total execution time: " + (endTime-startTime) + "ms");
                    System.out.println("- - - - - - - - - -");

                }

            }
            System.out.println("Proxy finished it's work.");
            return value;
        }
    }
}
