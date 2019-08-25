package HomeTasks.HomeTaskEighth.ProxyTester.ProxyWithAnnot;

public class PWAClass implements PWAInterface {
    @PWAAnnotation
    @Override
    public String concat(String s1, String s2) {
        return s1+s2;
    }
}
