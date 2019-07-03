package HomeTask.SecondTask;

public class Task7 {

    public static void main(String[] args) {

        calc(args);

    }

    public static void calc(String[] args){

        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        double D = b * b - 4 * a * c;

        if (D > 0) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.printf("x1 = %.3f, x2 = %.3f", x1, x2);
        } else if (D == 0) {
            double x = -b / (2 * a);
            System.out.printf("x = %.3f", x);
        } else System.out.println("Корней не существует.");

    }

}
