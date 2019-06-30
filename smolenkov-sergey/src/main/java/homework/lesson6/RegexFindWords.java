package homework.lesson6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFindWords {

    public static void main(String[] args) {

        String text = "\n" +
                "\n" +
                "A regular expression defines a search pattern for strings. " +
                "The abbreviation for regular expression is regex. " +
                "The search pattern can be anything from a simple character, " +
                "a fixed string or a complex expression containing special characters describing the pattern. " +
                "The pattern defined by the regex may match one or several times or not at all for a given string.\n" +
                "\n" +
                "Regular expressions can be used to search, edit and manipulate text.\n" +
                "\n" +
                "The process of analyzing or modifying a text with a regex is called: " +
                "The regular expression is applied to the text/string. " +
                "The pattern defined by the regex is applied on the text from left to right. " +
                "Once a source character has been used in a match, it cannot be reused. " +
                "For example, the regex aba will match ababababa only two times (aba_aba__).\n";

        Pattern sentence = Pattern.compile("\\b([a-zA-Z]){4}\\b");
        Matcher matcher = sentence.matcher(text);

        while (matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }

    }
}
