package HomeTasks;

//7.Найти корни квадратного уравнения. Параметры уравнения передавать как аргументы командной строки.
public class SolutionOfQuadraticQuation {

    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Integer.parseInt(args[2]);
        double D = b * b - 4 * a * c;

        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("Solution: x1 = " + x1 + ", x2 = " + x2);
        }
        else if (D == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("Solution : x = " + x);
        }
        else {
            System.out.println("Not exist real roots of solution!");
        }


    }

}

