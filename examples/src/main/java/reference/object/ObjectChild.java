package reference.object;

import java.util.Objects;

public class ObjectChild implements Cloneable{

    private String name = "ObjectChild";

    public ObjectChild() {
    }

    private ObjectChild(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {

        if (name == null)
            return 0;

        int result = 1;

        result = 31 * result + name.hashCode();

        return result;

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ObjectChild child = (ObjectChild) o;
        return name.equals(child.name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
