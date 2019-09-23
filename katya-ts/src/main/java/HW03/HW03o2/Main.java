package HW03.HW03o2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();

        System.out.println("Perimeter of a circle: " + circle.getPerimeter());
        System.out.println("Area of a circle: " + circle.getArea());
        Rectangle rectangle = new Rectangle();
        System.out.println("Perimeter of a rectangle: " + rectangle.getPerimeter());
        System.out.println("Area or a rectangle: " + rectangle.getArea());
    }
}