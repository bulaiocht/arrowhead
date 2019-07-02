package homework.lesson6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFindID {

    public static void main(String[] args) {

        String text = " Валидные примеры: 11 304 982, 39 683 234, 139 920 393, 150 000 000, 27 278 542, 11 598 175" +
                "Невалидные примеры: 1 304 982, 153 349 111, 053 394 111, 3 394 234, 89 909 98, 050 459 766, " +
                "234 678 848, 2346777776, 5678";

        Pattern sentence = Pattern.compile("(1[0-4]\\d\\s\\d{3}\\s\\d{3})|(\\D[1-9]\\d\\s\\d{3}\\s\\d{3})|" +
                "(150\\s\\d{3}\\s\\d{3})");
        Matcher matcher = sentence.matcher(text);

        while (matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
