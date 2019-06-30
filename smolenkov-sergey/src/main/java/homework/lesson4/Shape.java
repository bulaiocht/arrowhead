package homework.lesson4;

public abstract class Shape {

    private String color = "red";

    public abstract double getPerimeter();

    public abstract double getArea();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
