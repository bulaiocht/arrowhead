package HomeTasks;//Создать класс, который принимает число с плавающей точкой, введенное пользователем в консоль, и выводит его в виде целого числа и экспоненты. (edited)
import java.util.Scanner;

public class FloatConvert {
    FloatConvert() {}

    private FloatConvert(float variable) {
        int exponent = 0;
        while (!(variable % 1 == 0)) {
            variable *= 10;
            exponent++;
        }
        int var = (int) variable;
        System.out.println("Integer:" + var + " Exponent:E-" + exponent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FloatConvert floatConvert = new FloatConvert(scanner.nextFloat());

    }
}