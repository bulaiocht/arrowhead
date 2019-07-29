package HomeTasks.hometask5.abstracts;

public abstract class Shape {
    final private static String COLOR = "red";

    public abstract double getArea();

    public abstract double getPerimetr();


    public String getColor() {
        return COLOR;
    }
}
