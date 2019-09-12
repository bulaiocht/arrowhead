package homework.lesson2;

import org.jetbrains.annotations.NotNull;

public class task5 {

//    5. Определить в какую переменную вместится число. Число передавать как аргумент командной строки.

    public static void main(@NotNull String[] args) {

        byte b;
        double d;
        int i;
        float f;
        long l;
        short s;

        String argumentsValue = args[0];

        String value;
        try {
            Double.parseDouble(argumentsValue);
            value = "Double";
            printValue(value);
            Float.parseFloat(argumentsValue);
            value = "Float";
            printValue(value);
            Long.parseLong(argumentsValue);
            value = "Long";
            printValue(value);
            Integer.parseInt(argumentsValue);
            value = "Integer";
            printValue(value);
            Short.parseShort(argumentsValue);
            value = "Short";
            printValue(value);
            Byte.parseByte(argumentsValue);
            value = "Byte";
            printValue(value);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }

    }

    public static void printValue(String s) {
        System.out.printf("Match to %s\n", s);
    }
}
