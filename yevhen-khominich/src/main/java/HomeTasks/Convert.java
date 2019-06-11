package HomeTasks;

//6.Cконвертировать число переданное как аргумент командной строки в градусы по шкале Фаренгейта и в градусы по шкале Кельвина и вывести их в консоль.
public class Convert {
    public static void main(String[] args) {

        double celsius = Double.parseDouble(args[0]);
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.8 + 32;

        System.out.println("KelvinScale:" + kelvin);
        System.out.println("FahrenheitScale:" + fahrenheit);

    }

}
