package HomeTasks.HomeTaskThird.Task2;

public class Triangle extends Shape {
    private String color;
    private double sideLength1;
    private double sideLength2;
    private double sideLength3;
    private String type ;

    public Triangle(){
        this.color = "red";
        this.sideLength1 = 1.0;
        this.sideLength2 = 1.0;
        this.sideLength3 = 1.0;
        this.type = "equilateral";

    }
    public Triangle(double sideLength1,double sideLength2,double sideLength3){
        this.color = "red";
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.sideLength3 = sideLength3;
        if(sideLength1==sideLength2&&sideLength2==sideLength3){
            this.type = "equilateral";
        }else if(sideLength1==sideLength2||sideLength2==sideLength3||sideLength3==sideLength1){
            this.type = "isosceles";
        }else {
            this.type = "scalene";
        }
    }
    public Triangle(double sideLength1,double sideLength2,double sideLength3,String color){
        this.color = color;
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.sideLength3 = sideLength3;
        if(sideLength1==sideLength2&&sideLength2==sideLength3){
            this.type = "equilateral";
        }else if(sideLength1==sideLength2||sideLength2==sideLength3||sideLength3==sideLength1){
            this.type = "isosceles";
        }else {
            this.type = "scalene";
        }
    }
    @Override
    public double getPerimeter() {
        return sideLength1+sideLength2+sideLength3;
    }

    @Override
    public double getArea() {
        double perimetr = sideLength1+sideLength2+sideLength3;
        return Math.sqrt(perimetr*(perimetr-sideLength1)*(perimetr-sideLength2)*(perimetr-sideLength3));
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSideLength1() {
        return sideLength1;
    }

    public void setSideLength1(double sideLength1) {
        this.sideLength1 = sideLength1;
    }

    public double getSideLength2() {
        return sideLength2;
    }

    public void setSideLength2(double sideLength2) {
        this.sideLength2 = sideLength2;
    }

    public double getSideLength3() {
        return sideLength3;
    }

    public void setSideLength3(double sideLength3) {
        this.sideLength3 = sideLength3;
    }

    public String getType() {
        return type;
    }


}
