package HomeTask.ThirdTask.task2;

public class Triangle extends Shape{

    String type = "equilateral";
    private double length1 = 1.0;
    private double length2 = 1.0;
    private double length3 = 1.0;
    private String color = "red";

    public Triangle(){

    }

    public Triangle(double length1, double length2, double length3) {
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
        if (length1==length2&&length1==length3){
            type = "equilateral";
        } else if ((length1==length2&&length1!=length3)||(length1==length3&&length1!=length2)
                    ||(length2==length3&&length2!=length1)){
            type = "isosceles";
        } else {
            type = "scalene";
        }
    }

    public Triangle(double length1, double length2, double length3, String color) {
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
        this.color = color;
    }

    public String getType(){
        return type;
    }

    @Override
    public double getPerimeter() {
        return length1+length2+length3;
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter();
        return Math.sqrt(halfPerimeter*(halfPerimeter-length1)*(halfPerimeter-length2)*(halfPerimeter-length3));
    }
}
