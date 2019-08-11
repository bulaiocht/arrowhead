package HW2.Shapes;

public abstract class Shape {
    private String color = "red";  //final? static?

    public abstract double getPerimeter ();
    public abstract double getArea ();
    public abstract String getColor ();
}
