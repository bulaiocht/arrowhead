package HomeTasks.HomeTaskEighth.ReflectionRunner;

import HomeTasks.HomeTaskEighth.Utils.ReflectionPrinter;

import java.lang.reflect.InvocationTargetException;

public class PrinterRunner {
    static ReflectionPrinter reflectionPrinter1 ;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class<?> reflectionPrinter = Class.forName("HomeTasks.HomeTaskEighth.Utils.ReflectionPrinter");

        ReflectionPrinter.infoAboutSome("HomeTasks.HomeTaskEighth.Utils.ReflectionPrinter");

//        String[]as = new String[]{"as"};
//
//        ReflectionPrinter reflectionPrinter2 = ReflectionPrinter.creatExmpl(reflectionPrinter1,
//                "HomeTasks.HomeTaskEighth.Utils.ReflectionPrinter", as);
//
//        reflectionPrinter2.str("sa");
    }

}
