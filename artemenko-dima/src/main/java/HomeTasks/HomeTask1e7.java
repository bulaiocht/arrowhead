package HomeTasks;

public class HomeTask1e7 {
//    7.  Найти корни квадратного уравнения. Параметры уравнения передавать как аргументы командной строки.

    public static void main (String [] args){
        System.out.println("The first 3 arguments\n" +
                "will be used as parameters of the quadratic equation\n" +
                "a, b, c accordingly");

        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double D;

        D = b * b - 4 * a * c;
        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("Roots of the equation: x1 = " + x1 + ", x2 = " + x2);
        }
        else if (D == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("Equation has a single root: x = " + x);
        }
        else {
            System.out.println("The equation has no real roots!");
        }
    }
}
