//Найти любое четырехбуквенное слово в тексте, Собрать все такие слова.

package HomeTasks.hometask3;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    public static void main(String[] args) {
        searchFourLetterWord("White shirt now red, my bloody nose\n" +
                "Sleeping, you're on your tippy toes\n" +
                "Creeping around like no one knows\n" +
                "Think you're so criminal\n" +
                "Bruises, on both my knees for you\n" +
                "Don't say thank you or please\n" +
                "I do what I want when I'm wanting to\n" +
                "My soul? So cynical\n" +
                "So you're a tough guy\n" +
                "Like it really rough guy\n" +
                "Just can't get enough guy\n" +
                "Chest always so puffed guy\n" +
                "I'm that bad type\n" +
                "Make your mama sad type\n" +
                "Make your girlfriend mad tight\n" +
                "Might seduce your dad type\n" +
                "I'm the bad guy, duh\n" +
                "I'm the bad guy\n" +
                "I like it when you take control\n" +
                "Even if you know that you don't\n");

    }

    public static void searchFourLetterWord(String text) {
        StringJoiner result = new StringJoiner(", ", "All 4-letter's words : ", "");
        Pattern regex = Pattern.compile("\\b[a-z]{4}\\b");
        Matcher matcher = regex.matcher(text);

        while (matcher.find()) {
            result.add(matcher.group());
        }

        System.out.println(result);

    }

}
