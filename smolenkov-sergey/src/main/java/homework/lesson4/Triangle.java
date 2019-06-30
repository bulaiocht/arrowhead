package homework.lesson4;

public class Triangle extends Shape {

    public static final String EQUILATERAL = "Equilateral";
    public static final String ISOSCELES = "Isosceles";
    public static final String SCALENE = "Scalene";
    public static final double DEFAULT_LENGTH = 1.0;

    private double sideLength1;
    private double sideLength2;
    private double sideLength3;
    private String type;

    public Triangle() {
        this.sideLength1 = DEFAULT_LENGTH;
        this.sideLength2 = DEFAULT_LENGTH;
        this.sideLength3 = DEFAULT_LENGTH;
        ensureType(sideLength1, sideLength2, sideLength3);
    }

    public Triangle(double sideLength1,
                    double sideLength2,
                    double sideLength3) {

        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.sideLength3 = sideLength3;
        ensureType(sideLength1, sideLength2, sideLength3);
    }

    public Triangle(double sideLength1,
                    double sideLength2,
                    double sideLength3,
                    String color) {

        super.setColor(color);
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.sideLength3 = sideLength3;
        ensureType(sideLength1, sideLength2, sideLength3);
    }

    private void ensureType(final double sideLength1,
                            final double sideLength2,
                            final double sideLength3) {

        if (sideLength1 == sideLength2 && sideLength2 == sideLength3) {
            this.type = EQUILATERAL;
        } else if (sideLength1 == sideLength2 || sideLength2 == sideLength3 || sideLength3 == sideLength1) {
            this.type = ISOSCELES;
        } else {
            this.type = SCALENE;
        }
    }

    @Override
    public double getPerimeter() {
        return sideLength1 + sideLength2 + sideLength3;
    }

    @Override
    public double getArea() {
        double p = sideLength1 + sideLength2 + sideLength1;
        return Math.sqrt(p * (p - sideLength1) * (p - sideLength2) * (p - sideLength3));
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
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
