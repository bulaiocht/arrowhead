package HomeTasks.HomeTask7.ClassExample;

import HomeTasks.HomeTask7.OwnAnnotation;

final public class TestClass extends testParentClass implements TestInterface2 {

    private int int2 = 2;
    protected int int3 = 3;
    public int int4 = 4;
    static int int5 = 5;
    final String str2 = "str2";

    public TestClass(String str1, int int2, int int3, int int4, int int5) {
        super( str1 );
        this.int2 = int2;
        this.int3 = int3;
        this.int4 = int4;
        this.int5 = int5;
    }

    public TestClass() {
    }

    protected TestClass(String str1) {
        super( str1 );
    }

    @OwnAnnotation
    @Override
    public void method1() {
        super.method1();
        for (int a = 0; a<1000000 ; a++){

        }
        System.out.println("method1 done");
    }

    public static void method3(){
    }

    @OwnAnnotation
    private static void method4(){

        System.out.println("method4 done");
    }

    protected int method5(){
        return 0;
    }

    @OwnAnnotation
    @Override
    public double method2() {
        for (int a = 0; a<1000000 ; a++){
            int4 += Math.pow( int4, a);
        }
        System.out.println("method2 done");
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "ClassExample{" );
        sb.append( "int2=" ).append( int2 );
        sb.append( ", int3=" ).append( int3 );
        sb.append( ", int4=" ).append( int4 );
        sb.append( ", str2='" ).append( str2 ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }
}
