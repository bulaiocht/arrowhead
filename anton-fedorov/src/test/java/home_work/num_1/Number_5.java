package home_work.num_1;

public class Number_5 {
    /**
     * 5. Определить в какую переменную вместится число. Число передавать как аргумент командной строки.
     * Создать класс, который определяет и выводит сообщение в консоль в какой тип данных поместится число, которое было передано юзером как аргумент коммандной строки.
     */
    public static void main(String[] args) {
        byte b;
        short s;
        int i;
        long l;
        float f;
        double d;
        String value = args[0];

        String res ;
        try {
            Double.parseDouble(value);
            res = "Double";
            print(res);
            Float.parseFloat(value);
            res = "Float";
            print(res);
            Long.parseLong(value);
            res = "Long";
            print(res);
            Integer.parseInt(value);
            res = "Integer";
            print(res);
            Short.parseShort(value);
            res = "Short";
            print(res);
            Byte.parseByte(value);
            res = "Byte";
            print(res);

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void print(String s) {
        System.out.printf("Match to %s\n", s);
    }
}
