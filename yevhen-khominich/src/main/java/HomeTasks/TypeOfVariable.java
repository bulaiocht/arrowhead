package HomeTasks;//5.Определить в какую переменную вместится число. Число передавать как аргумент командной строки.

public class TypeOfVariable {

    TypeOfVariable() {}

    private TypeOfVariable(String[] args) {

        double number = Double.parseDouble(args[0]);

        if (number % 1 != 0) {
            int indexExp = args[0].indexOf(".");
            String exponent = args[0].substring(indexExp);

            if (number >= Float.MIN_VALUE && number <= Float.MAX_VALUE && exponent.length() <= 45)
                System.out.println("It is Float ");
            else System.out.println("It is Double");
        } else if (number >= Byte.MIN_VALUE && number <= Byte.MAX_VALUE)
            System.out.println("It is byte");
        else if (number >= Short.MIN_VALUE && number <= Short.MAX_VALUE)
            System.out.println("It is short");
        else if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE)
            System.out.println("It is int");
        else System.out.println("It is long");
    }

    public static void main(String[] args) {
        TypeOfVariable typeOfVariable = new TypeOfVariable(args);
    }
}

