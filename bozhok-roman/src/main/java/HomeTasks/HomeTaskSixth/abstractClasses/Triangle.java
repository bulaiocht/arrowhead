package HomeTasks.HomeTaskSixth.abstractClasses;

import HomeTasks.HomeTaskSixth.interfaces.Shape;

public abstract class Triangle implements Shape {
    protected String color;
    protected double sideLength1;
    protected double sideLength2;
    protected double sideLength3;
    protected String type ;

    protected Triangle(){
        this.color = Shape.COLOR;
        this.sideLength1 = Shape.DEFAULT_NUMBER;
        this.sideLength2 = Shape.DEFAULT_NUMBER;
        this.sideLength3 = Shape.DEFAULT_NUMBER;
        this.type = "equilateral";

    }
    protected Triangle(double sideLength1,double sideLength2,double sideLength3){
        this.color = Shape.COLOR;
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.sideLength3 = sideLength3;
        whatType(sideLength1,sideLength2,sideLength3);
    }
    protected Triangle(double sideLength1,double sideLength2,double sideLength3,String color){
        this.color = color;
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.sideLength3 = sideLength3;
        whatType(sideLength1,sideLength2,sideLength3);
    }

    private void whatType (double sideLength1,double sideLength2,double sideLength3){
        if(sideLength1==sideLength2&&sideLength2==sideLength3){
            this.type = "equilateral";
        }else if((sideLength1==sideLength2&&sideLength1!=sideLength3)
                ||(sideLength1==sideLength3&&sideLength1!=sideLength2)
                ||(sideLength2==sideLength3&&sideLength2!=sideLength1)){
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
        double perimeter = sideLength1+sideLength2+sideLength3;
        return Math.sqrt(perimeter*(perimeter-sideLength1)*(perimeter-sideLength2)*(perimeter-sideLength3));
    }

    @Override
    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}
