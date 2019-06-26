//Выбрать из текста идентификаторы сотрудников, которые отвечают следующим критериям:
//1)начинаются с 2 чисел (без ведущего нуля), потом 3 числа (с возможным ведущим нулем), потом еще 3 числа (с возможным ведущим нулем), разделенные пробелами
//2)начинаются с 3 чисел (без ведущего нуля), потом 3 числа (с возможным ведущим нулем), потом еще 3 числа (с возможным ведущим нулем), разделенные пробелами


package HomeTasks.hometask3;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Identificator {
    public static void main(String[] args) {
        String text = "200 333 568 show me 150 000 000 inters " +
                "111 453 313  en 99 99 99 whe 10 055 321 lol 401 01 sub " +
                "11 304 982 no 39 683 234 p 139 920 393 153 049 011 f " +
                "133 394 111 3 394 234 wow 139 909 982 45 042 033 "+
                "99 011 099 ru224 414 34";
        searchIdTwoSymbol(text);
        searchIdThreeSymbol(text);

    }

    public static void searchIdTwoSymbol(String text) {

        StringJoiner idenficators = new StringJoiner(", ", "Idenficators(start 2 symbol) : ", "");
        Pattern regex = Pattern.compile("\\b[1-9]\\d\\s\\d{3}\\s\\d{3}\\b");
        Matcher matcher = regex.matcher(text);

        while (matcher.find()) {
            idenficators.add(matcher.group());
        }

        System.out.println(idenficators);
    }

    public static void searchIdThreeSymbol(String text) {
        StringJoiner idenficators = new StringJoiner(",");
        Pattern regex = Pattern.compile("\\b[1-9]\\d{2}\\s\\d{3}\\s\\d{3}\\b");
        Matcher matcher = regex.matcher(text);

        while (matcher.find()) {
            idenficators.add(matcher.group());
        }

        checkAndTransform(idenficators);
    }

    private static void checkAndTransform(StringJoiner idenficators) {
        String[] temp = idenficators.toString().replaceAll("\\s+", "").split(",");
        StringJoiner result = new StringJoiner(", ", "Idenficators(start 3 symbol) : ", "");

        for (String s : temp) {
            if (Integer.valueOf(s) <= 150_000_000) {
                result.add(s.substring(0, 3) + " " + s.substring(3, 6) + " " + s.substring(6, 9));
            }
        }
        System.out.println(result);

    }

}



