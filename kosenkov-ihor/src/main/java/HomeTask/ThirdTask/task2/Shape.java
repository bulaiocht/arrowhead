package HomeTask.ThirdTask.task2;

public abstract class Shape {

    private String color = "red";

    public abstract double getPerimeter();
    public abstract double getArea();

    public String getColor(){
        return color;
    }

}
