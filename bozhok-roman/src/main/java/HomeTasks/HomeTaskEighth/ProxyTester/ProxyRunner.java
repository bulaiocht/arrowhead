package HomeTasks.HomeTaskEighth.ProxyTester;

import HomeTasks.HomeTaskEighth.ProxyTester.ProxyWithAnnot.PWAAnnotation;
import HomeTasks.HomeTaskEighth.ProxyTester.ProxyWithAnnot.PWAClass;
import HomeTasks.HomeTaskEighth.ProxyTester.ProxyWithAnnot.PWAInterface;
import HomeTasks.HomeTaskEighth.ProxyTester.StandartProxy.InterFace;
import HomeTasks.HomeTaskEighth.Utils.PrCrWithAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ProxyRunner {
    static InterFace interFace;
    static PWAInterface pwaInterface;
    public static void main(String[] args) throws ClassNotFoundException {

//        StandartClass stclass = new StandartClass();
//
//        InterFace proxy = ProxyCreater.getProxy(stclass,InterFace.class, interFace);
//
//        proxy.printer("s");

        PWAClass pwaClass = new PWAClass();

        PWAInterface proxy = PrCrWithAnnotation.getProxy(pwaClass, PWAInterface.class,PWAAnnotation.class, pwaInterface);

        String concat = proxy.concat("1", "2");
        System.out.println(concat);


    }
}
