package HomeTasks.HomeTaskFourth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
    //Проверка первого задания
        String string = new String("tErd asdka ortt dfsm sdfksdfls dsfsd fdfd gfgf s;fldk");

        System.out.println(Main.task1(string));
    //Проверка второго задания
        String string1 = new String(" 150 000 000, 10 000 000, 11 304 982," +
                " 39 683 234, 139 920 393,153 349 111, 053 394 111, 3 394 234, 89 909 98");

        System.out.println(Main.task2(string1));

    }

    //Найти любое четырехбуквенное слово в тексте, Собрать все такие слова.
    public static String task1(String text) {

        String s1 = new String();

        StringBuilder builder = new StringBuilder();

        Pattern pattern = Pattern.compile("((^[a-z]{4}\\b)|(\\b[a-z]{4}\\b))", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {

            builder.append(matcher.group());
            builder.append(" ");
        }

        s1 = builder.toString();

        return s1;
    }

    //Выбрать из текста идентификаторы сотрудников, которые отвечают следующим критериям:
    //- начинаются с 2 чисел (без ведущего нуля), потом 3 числа (с возможным ведущим нулем),
    // потом еще 3 числа (с возможным ведущим нулем), разделенные пробелами.
    //- начинаются с 3 чисел (без ведущего нуля), потом 3 числа (с возможным ведущим нулем),
    // потом еще 3 числа (с возможным ведущим нулем), разделенные пробелами.
    //- числа выходящие за границы 10 000 000 и150 000 000 не валидны.
    public static String task2(String text) {

        String s2 = new String();

        StringBuilder builder = new StringBuilder();

        Pattern pattern = Pattern.compile("((([^\\d][1-9][0-9])(\\s)(\\d{3})(\\s)(\\d{3}))|" +
                "(([1][0-4][0-9])(\\s)(\\d{3})(\\s)(\\d{3}))|(150 000 000))");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            builder.append(matcher.group());
            builder.append("\n");
        }

        s2 = builder.toString();

        return s2;
    }
}
