package HomeTasks.HomeTask4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//8.  Определить частоту повторяемости букв и слов в тексте.
public class HomeTask4e8 {
    public static void main(String[] args) throws IOException {

        System.out.print("What word to find: ");
        Scanner sc1 = new Scanner(System.in);
        String word = sc1.nextLine();
        System.out.print("What letter to find: ");
        Scanner sc2 = new Scanner(System.in);
        String letter = sc2.nextLine();

        int countLetter = 0;
        int countWord = 0;

    InputStream bookIn = new BufferedInputStream(
            new FileInputStream("artemenko-dima\\src\\main\\resources\\book.txt"));

        if (bookIn != null) {

        Scanner scanner = new Scanner(bookIn);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Pattern patternLetter = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
            Matcher matcherLetter = patternLetter.matcher(line);

            Pattern patternWord = Pattern.compile(letter, Pattern.CASE_INSENSITIVE);
            Matcher matcherWord = patternWord.matcher(line);

            while (matcherLetter.find()) {
                countLetter++;
            }
            while (matcherWord.find()) {
                countWord++;
            }
        }
            System.out.println("The word " + "\"" + word + "\"" + " is repeated: " + countWord + " times");
            System.out.println("The letter " + "\"" + letter + "\"" + " is repeated: " + countLetter + " times");
        }
    }
}