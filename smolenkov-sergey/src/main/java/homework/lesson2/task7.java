package homework.lesson2;

import java.util.Scanner;

public class task7 {

    public static void main(String[] args) {

        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a = ");
        a = sc.nextDouble();
        System.out.println("Enter b = ");
        b = sc.nextDouble();
        System.out.println("Enter c = ");
        c = sc.nextDouble();
        double d = b * b - 4 * a * c;
        if (d < 0) {
            System.out.println();
            System.out.println("************");
            System.out.println();
            System.out.println("There are not any equation roots");

        }else if (d == 0) {
            double x = (-b) / (2 * a);
            System.out.println();
            System.out.println("************");
            System.out.println();
            System.out.println("Equation root: ");
            System.out.println("x = " + x);
        } else {
            double x1 = (-b+Math.sqrt(d))/(2*a);
            double x2 = (-b-Math.sqrt(d))/(2*a);
            System.out.println();
            System.out.println("************");
            System.out.println();
            System.out.println("Equation roots: ");
            System.out.println("x1 = "+x1);
            System.out.println("x2 = "+x2);
        }
        sc.close();
    }
}
