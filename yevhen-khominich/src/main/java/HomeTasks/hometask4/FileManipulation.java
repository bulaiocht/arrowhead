package HomeTasks.hometask4;

import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManipulation {

    private static final String SRC = String.format("yevhen-khominich%ssrc%smain%sresources%spoem.txt",
            File.separator,
            File.separator,
            File.separator,
            File.separator);
    private static final String FIRSTTASK = String.format("yevhen-khominich%ssrc%smain%sresources%sFirstpoem_copy.txt",
            File.separator,
            File.separator,
            File.separator,
            File.separator);
    private static final String SECONDTASK = String.format("yevhen-khominich%ssrc%smain%sresources%sSecondpoem_copy.txt",
            File.separator,
            File.separator,
            File.separator,
            File.separator);
    private static final String THIRDTASK = String.format("yevhen-khominich%ssrc%smain%sresources%sThirdpoem_copy.txt",
            File.separator,
            File.separator,
            File.separator,
            File.separator);


    public static void main(String[] args) throws IOException {

        deleteSub("the");
        replaseSub("roads", "HELLO");
        changeFirstLetterOfWords();
        searchVowelLetter();

        System.out.println("Words that matches : ");
        searchMatchFirstAndLastLetter();

        System.out.println("Long and short words : ");
        searchShortAndLongWords();

        System.out.println();
        countAndSortWords(new String[]{"roads", "i", "to", "for", "and"});

        System.out.println();
        countLetterAndWord("a", "fair");

    }

    // 1.В каждой строке найти и  удалить заданную подстроку
    public static void deleteSub(String delete) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(SRC));
                BufferedWriter writer = new BufferedWriter(new FileWriter(FIRSTTASK))
        ) {

            while (true) {
                String line = reader.readLine();
                if (line == null) break;

                writer.write(line.replaceAll(delete, ""));
                writer.newLine();

            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2.В  каждой  строке  стихотворения  найти  и  заменить  заданную  подстроку на  подстроку иной длины.
    public static void replaseSub(String delete, String result) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(SRC));
                BufferedWriter writer = new BufferedWriter(new FileWriter(SECONDTASK))
        ) {
            while (true) {
                String line = reader.readLine();
                if (line == null) break;

                writer.write(line.replaceAll(delete, result));
                writer.newLine();

            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3.В  каждом  слове  заменить  первую  букву  слова на  прописную.
    public static void changeFirstLetterOfWords() {

        try (
                BufferedReader reader = new BufferedReader(new FileReader(SRC));
                BufferedWriter writer = new BufferedWriter(new FileWriter(THIRDTASK))
        ) {
            while (true) {
                String line = reader.readLine();
                if (line == null) break;

                for (Matcher m; (m = Pattern.compile("\\b[a-z]").matcher(line)).find(); line = m.replaceFirst(m.group().toUpperCase()))
                    ;

                writer.write(line);
                writer.newLine();

            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4.В каждой строке найти слова, начинающиеся с  гласной буквы.
    public static void searchVowelLetter() {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(SRC));
        ) {

            StringJoiner result = new StringJoiner(", ", "Words with first vowel letter  : ", "");
            while (true) {
                String line = reader.readLine();
                if (line == null) break;

                Pattern regex = Pattern.compile("\\b[aqeyuio]\\w+");
                Matcher matcher = regex.matcher(line);

                while (matcher.find()) {
                    result.add(matcher.group());
                }

            }
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 5.Найти  и  вывести  слова  текста,  для  которых  последняя  буква  одного  слова совпадает с  первой буквой следующего слова.
    public static void searchMatchFirstAndLastLetter() {
        InputStream is = FileManipulation.class.getClassLoader().getResourceAsStream("poem.txt");
        Scanner scanner = new Scanner(is);
        while (scanner.hasNext()) {
            String line = scanner.nextLine().replaceAll("[,.]", "");
            findWords(line);
        }

    }

    // 6.Найти в каждой строке самое длинное и самое короткое слово.
    public static void searchShortAndLongWords() {

        InputStream is = FileManipulation.class.getClassLoader().getResourceAsStream("poem.txt");
        Scanner scanner = new Scanner(is);
        int numberOfLine = 1;

        while (scanner.hasNext()) {
            String line = scanner.nextLine().replaceAll("[,.]", "");
            System.out.print("Line " + numberOfLine + " ");
            findMinAndMax(line);
            numberOfLine++;

        }


    }

    // 7.В каждой  строке  подсчитать  частоту  повторяемости  каждого  слова  из  заданного  списка  и  вывести  эти  слова  в  порядке возрастания частоты повторяемости.
    public static void countAndSortWords(String[] words) {
        InputStream is = FileManipulation.class.getClassLoader().getResourceAsStream("poem.txt");

        Scanner scanner = new Scanner(is);

        int[] counters = new int[words.length];

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Pattern pattern = Pattern.compile("\\b([a-z]+)\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {

                for (int i = 0; i < words.length; i++) {
                    if ((matcher.group().toLowerCase()).equals(words[i])) {
                        counters[i]++;
                    }
                }
            }
        }
        sortAndShow(counters, words);

    }

    // 8.Определить частоту повторяемости букв и слов в тексте.
    public static void countLetterAndWord(String letter, String word) {

        InputStream is = FileManipulation.class.getClassLoader().getResourceAsStream("poem.txt");
        Scanner scanner = new Scanner(is);

        int countLetter = 0;
        int countWord = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Pattern patternLetter = Pattern.compile(letter, Pattern.CASE_INSENSITIVE);
            Matcher matcherLetter = patternLetter.matcher(line);

            Pattern patternWord = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
            Matcher matcherWord = patternWord.matcher(line);

            while (matcherLetter.find()) {
                countLetter++;
            }

            while (matcherWord.find()) {
                countWord++;
            }

        }
        System.out.println("Frequency of occurrence " + "\"" + word + "\"" + " : " + countWord);
        System.out.println("Frequency of occurrence " + "\"" + letter + "\"" + " : " + countLetter);
    }


    private static void findMinAndMax(String line) {
        String[] words = line.split(" ");

        int minLength = words[0].length();
        int maxLength = words[0].length();

        String minimWord = words[0];
        String maxWord = words[0];

        for (String word : words) {
            if (minLength > word.length()) {
                minLength = word.length();
                minimWord = word;
            }
            if (maxLength < word.length()) {
                maxLength = word.length();
                maxWord = word;
            }
        }
        System.out.println("ShortestWord : " + minimWord + " " + "and" + " " + "Longestword: " + maxWord);
    }

    private static void findWords(String line) {
        String[] words = line.split(" ");
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < words.length - 1; i++) {

            if (words[i].charAt(words[i].length() - 1) == words[i + 1].charAt(0)) {
                result.add(words[i]).add(words[i + 1]);
                System.out.println("Pairs : " + result);
            }
        }

    }

    private static void sortAndShow(int[] counters, String[] words) {

        boolean isSorted = false;
        int temp;
        String temp2;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < counters.length - 1; i++) {
                if (counters[i] > counters[i + 1]) {
                    isSorted = false;

                    temp = counters[i];
                    counters[i] = counters[i + 1];
                    counters[i + 1] = temp;

                    temp2 = words[i];
                    words[i] = words[i + 1];
                    words[i + 1] = temp2;

                }
            }
        }

        for (int i = 0; i < counters.length; i++) {
            System.out.println("Word " + "\"" + words[i] + "\"" + " Number of matches " + counters[i]);
        }


    }


}

