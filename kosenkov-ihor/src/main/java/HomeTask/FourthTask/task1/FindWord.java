package HomeTask.FourthTask.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWord {

    public static void main(String[] args) {
        searchWord("RegExr was created by gskinner.com, and is proudly hosted by Media Temple.\n" +
                "\n" +
                "Edit the Expression & Text to see matches. Roll over matches or the expression for details. " +
                "PCRE & Javascript flavors of RegEx are supported.\n" +
                "\n" +
                "The side bar includes a Cheatsheet, full Reference, and Help. You can also Save & Share " +
                "with the Community, and view patterns you create or favorite in My Patterns.\n" +
                "\n" +
                "Explore results with the Tools below. Replace & List output custom results. Details " +
                "lists capture groups. Explain describes your expression in plain English.\n");
    }

    public static void searchWord(String text){

        Pattern find = Pattern.compile("\\b([a-zA-Z]){4}\\b");
        Matcher matcher = find.matcher(text);

        System.out.println("Words with four letters: ");
        while (matcher.find()){
            String group = matcher.group();

            System.out.printf("\"%s\" ", group);
        }

    }

}
