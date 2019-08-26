package HomeTasks.HomeTask7.TestClass;

public class testParentClass implements testInterface1{

    final int int1 = 1;
    private String str1 = "str1";

    public testParentClass(String str1) {
        this.str1 = str1;
    }

    public testParentClass() {

    }

    @Override
    public void method1() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "testParentClass{" );
        sb.append( "int1=" ).append( int1 );
        sb.append( ", str1='" ).append( str1 ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }
}
