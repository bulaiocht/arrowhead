package home_work.lesson_2.shapes;

public abstract class Shape {
    private String color = "red";

    public abstract double getPerimeter();

    public abstract double getArea();

    public String getColor() {
        return color;
    }
}
