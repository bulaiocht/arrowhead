package HW06;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FourLetters {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/katya/IdeaProjects/hillel-homeworks/src/main/java/HW06/lyrics");
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        String text;

        while ((text = reader.readLine()) != null) {
            Pattern pattern = Pattern.compile("\\b[a-zA-Z]{4}\\b");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.print(matcher.group() + " ");
            }
        }
        System.out.println();
    }
}
