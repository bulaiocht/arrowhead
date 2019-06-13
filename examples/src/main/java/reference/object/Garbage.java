package reference.object;

public class Garbage {

    private int number;

    public Garbage(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Garbage{" +
                "number=" + number +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + " releasing resources");
        super.finalize();
    }
}
