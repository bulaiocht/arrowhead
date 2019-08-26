package HomeTasks.HomeTask7.TestClass;

final public class TestClass extends testParentClass implements testInterface2 {

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

    @Override
    public void method1() {
        super.method1();
    }

    public static void method3(){
    }

    private static void method4(){
    }

    protected int method5(){
        return 0;
    }

    @Override
    public double method2() {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "TestClass{" );
        sb.append( "int2=" ).append( int2 );
        sb.append( ", int3=" ).append( int3 );
        sb.append( ", int4=" ).append( int4 );
        sb.append( ", str2='" ).append( str2 ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }
}
