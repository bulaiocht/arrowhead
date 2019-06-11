package HomeTasks;

public class HomeTask1e8 {
//    8. Создать класс, который принимает число с плавающей точкой,
//    введенное пользователем в консоль, и выводит его
//    в виде целого числа и экспоненты.
    public static void main (String [] args){
        for (String number : args)
            converter(number);
    }

    public static void converter(String str){
        double numberCon = Double.parseDouble(str);
        System.out.println(String.format("%1.0e",numberCon));
    }
}
    