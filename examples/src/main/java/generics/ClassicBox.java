package generics;


public class ClassicBox {

    private Object element;

    public ClassicBox() {
    }

    public ClassicBox(Object content) {
        this.element = content;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
}
