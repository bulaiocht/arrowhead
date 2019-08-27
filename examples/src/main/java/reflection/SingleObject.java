package reflection;

public class SingleObject {

    private String field;

    private SingleObject(String val) {
        this.field = val;
    }

    public String getField() {
        return field;
    }

}
