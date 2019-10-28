import com.somepac.StaticClass;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Properties;

import static com.somepac.StaticClass.*;

public class QuizTest {

    @Test
    public void name() {

        int[] ar = {5,5};
        int b = 1;

        ar[b] = b = 0;

        System.out.println(Arrays.toString(ar));

        AWTEvent awtEvent;

        ActionEvent e;

        ActiveEvent activeEvent;

        int g = com.somepac.StaticClass.val;

        int i = val;

        int j = StaticClass.val;

        char a = 65526;

        double sqrt = Math.sqrt(-1);

        byte c = 2;

        short d = 2;

        pShort(c, d);

        Double.isNaN(Double.NaN);

        System.out.println(Double.NaN == Double.NaN);
        //        int h = somepac.StaticClass.val;

    }
    private static void pShort(short c, short b){
        System.out.println(" " + (c + b) + (c + b));
    }


    @Test
    public void recursiveTest() {

        recur(99);

    }


    @Test
    public void d() {
        Boolean b1 = new Boolean(false);
        Boolean b2 = new Boolean(false);

        System.out.println(b1 || !b2 || !b1 || b2);


//        new D();
    }

    private static void recur(int a){

        if (a<= 100){
            System.out.print(" " + a);
            recur(++a);
            System.out.print(" " + a);
        }
    }


}

class A {
    public A() {
        System.out.println("A");
    }
}
class B {
    public B() {
        System.out.println("B");
    }
}
class C {
    public C() {
        System.out.println("C");
    }
}
class D extends C{
    private A a = new A();
    private static B b = new B();
    public D() {
        System.out.println("D");
    }
}



