package HomeTask.SecondTask;

public class Task6 {

    public static void main(String[] args) {

        double number = Double.parseDouble(args[0]);

        System.out.printf("%.2f градусов по Цельсию это %.2f градусов по Фаренгейту и %.2f градусов по Кельвину", number, toFarengeit(number), toKelvin(number));

    }

    public static double toFarengeit(double number){

        return number*1.8+32;

    }

    public static double toKelvin(double number){

        return number+273.15;

    }

}
