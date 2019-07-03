package HomeTask.SecondTask;

public class Task5 {

    public static void main(String[] args) {

        System.out.printf("Для числа %s оптимлаьный тип переменной - %s", args[0], variableType(args[0]));

    }

    public static String variableType(String numberString){
        double number = Double.parseDouble(numberString);
        if (number % 1 != 0){
            String exponent = numberString.substring(numberString.indexOf(".") + 1);
            if (number >= Float.MIN_VALUE && exponent.length() >= Float.MIN_EXPONENT
                    && number <= Float.MAX_VALUE && exponent.length() <= Float.MAX_EXPONENT){
                return "float";
            } else return "double";
        } else if (number >= Byte.MIN_VALUE && number <= Byte.MAX_VALUE) return "byte";
        else if (number >= Short.MIN_VALUE && number <= Short.MAX_VALUE) return "short";
        else if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) return "integer";
        else if (number >= Long.MIN_VALUE && number <= Long.MAX_VALUE) return "long";
        else return "BigDecimal";
    }

}
