package HomeTasks;

public class HomeTask1e6 {
//    6. Cконвертировать число переданное как аргумент командной строки
//    в градусы по шкале Фаренгейта и в градусы по шкале Кельвина и вывести их в консоль.
    public static void main(String[] args) {
    for (String number : args)
        converter(number);
    }

    public static void converter(String str){
        int tempC = Integer.parseInt(str);
        if (tempC > -274){// не ниже "полного нуля"
        int tempK = tempC + 273;
        int tempF = (int) ((1.8 * tempC) + 32);
            System.out.println("degrees Celsius: " + tempC + " C"+"\n" +
                    "degrees Fahrenheit: " + tempF + " F"+ "\n" +
                    "degrees Kelvin: " + tempK + "K" + "\n");
        }
        else {
            System.out.println("Wrong temperature indicated!");
        }
    }
}