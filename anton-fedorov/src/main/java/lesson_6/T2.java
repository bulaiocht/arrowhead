package lesson_6;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T2 {
    public static void main(String[] args) {

        String text = "This is something 6 Inside this text";
        String textWithEmail = "This is something user-name@yaypay.com 6 Inside this text";

        String email="a user-name@yaypay.com";

        Pattern sentece = Pattern.compile("([a-z]){3,10}([\\.\\-_])?([a-z]){3,10}@([a-z]){1,15}(\\.)([a-z]){2,5}");
        Pattern emailPattern = Pattern.compile("^([a-z]){3,10}([\\.\\-_])?([a-z]){3,10}@([a-z]){1,15}(\\.)([a-z]){2,5}$");

        Matcher matcher = sentece.matcher(textWithEmail);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            System.out.printf("start: %d end: %d\n", start, end);
            System.out.println(textWithEmail.substring(start, end));
            System.out.println(matcher.group());
        }

        Matcher matcher1 = emailPattern.matcher(email);

        while (matcher1.find()) {

            System.out.println(matcher1.group());
        }

//        Matcher matcher = sentece.matcher(text);
//        while (matcher.find()) {
//            String group = matcher.group();
//            System.out.println(group);
//        }

        String placeholter = matcher.replaceAll("placeholter");
        System.out.println(placeholter);


    }
}
