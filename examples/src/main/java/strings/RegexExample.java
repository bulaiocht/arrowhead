package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args) {

        String text = "there is something 8 Inside thIs text";

        String textWithEmail = "something user-name@mail.com Inside thIs text";

        String email = " a us@mail.com .,m";

        Pattern sentence = Pattern.compile("([a-z]){3,10}([\\.\\-_])?([a-z]){3,10}@([a-z]){1,15}(\\.)([a-z]){2,5}");

        Pattern emailPattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

        Matcher matcher = emailPattern.matcher(textWithEmail);

        while (matcher.find()) {

            int start = matcher.start();
            int end = matcher.end();

            System.out.printf("start: %d; end: %d\n", start, end);

            System.out.println(textWithEmail.substring(start, end));

            System.out.println(matcher.group());

            String placeholder = matcher.replaceAll("placeholder");

            System.out.println(placeholder);
        }

    }

}
