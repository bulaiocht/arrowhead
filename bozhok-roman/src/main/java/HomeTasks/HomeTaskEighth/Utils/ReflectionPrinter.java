package HomeTasks.HomeTaskEighth.Utils;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;


public class ReflectionPrinter {

    private static final StringBuilder infoAboutSome = new StringBuilder();


    private ReflectionPrinter (String var){

    }

    public static void infoAboutSome (String className) throws ClassNotFoundException {

        Class<?> testClass = Class.forName(className);
        Constructor<?>[] constructors = testClass.getDeclaredConstructors();
        Method[] methods = testClass.getDeclaredMethods();
        Class<?>[] interfaces = testClass.getInterfaces();
        Field[] fields = testClass.getDeclaredFields();
        Annotation[] annotations = testClass.getDeclaredAnnotations();

        consumer(testClass.getPackage(),"Package: ");
        consumer(annotations,"Annotations: ");
        consumer(testClass.getName(),"ClassName: ");
        consumer(testClass.getSuperclass(),"Extends: ");
        consumer(interfaces,"Implements: ");
        consumer(fields,"Fields: ");
        consumer(constructors,"Constructors: ");
        consumer(methods,"Methods: ");


        System.out.println(infoAboutSome);
    }

    private static<T extends AnnotatedElement> void consumer (T[] classes, String typePoint) throws ClassNotFoundException {

        infoAboutSome.append(typePoint+"\n");

        for (T aClass : classes) {

            infoAboutSome.append(aClass.toString()+"\n");
            Annotation[] declaredAnnotations = aClass.getDeclaredAnnotations();
            if (declaredAnnotations.length>0){
                infoAboutSome.append("Annotation for method: "+"\n");
            }
            for (Annotation declaredAnnotation : declaredAnnotations) {
                infoAboutSome.append(declaredAnnotation.toString()+"\n");
            }
        }


    }

    @Resource
    private static void consumer (Annotation[] classes,String typePoint){

        infoAboutSome.append(typePoint+"\n");

        for (Annotation ant : classes) {

            infoAboutSome.append(ant.toString()+"\n");
        }


    }
    private static<T> void consumer (T classes,String typePoint){

        infoAboutSome.append(typePoint+classes.toString()+"\n");


    }

    public static <T> T creatExmpl(T obj,String className,String[] strings) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Object o = new Object();
        Class<?> aClass = Class.forName(className);
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            declaredConstructor.setAccessible(true);
             o = declaredConstructor.newInstance(strings);
        }


        return (T)o;

    }
    public void str(String var){
        System.out.println(var);
    }







}
