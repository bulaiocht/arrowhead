package HW4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lyrics {

    private static final String SRC = "src\\resources\\lyrics.txt";
    private static final String COPY = "src\\resources\\lyrics_copy.txt";
    private static final String COPY2 = "src\\resources\\lyrics_copy2.txt";
    private static final String COPY3 = "src\\resources\\lyrics_copy3.txt";

    //В каждой строке найти и удалить заданную подстроку.
    public static void main(String[] args) {
        //removeSubstr("the");
        //replaceSubstr("I'm gonna ride 'til I can't no more", "!!!");
        //searchWordsThatStartsWithVowels();
        //showWords();
        //searchLongAndShort();
        //changeToUpperCase();
        //countRepeats("the",'a');
        String searchArray []={"the", "go", "a"};
        searchRepeats(searchArray);

    }

    //1. В каждой строке найти и удалить заданную подстроку.
    public static void removeSubstr(String substr) {

        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));
             BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(COPY));) {
            Scanner scanner = new Scanner(reader);
//                scanner.useDelimiter(Pattern.compile("\\s"));

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line == null) break;
                writer.write(line.replaceAll(substr, "").getBytes());
                writer.write("\n".getBytes());

            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

    }

    //2. В каждой строке стихотворения найти и заменить заданную подстроку на подстроку иной длины.
    public static void replaceSubstr(String substr, String replacement) {


        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));
             BufferedWriter writer = new BufferedWriter(new FileWriter(COPY2))) {

            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                writer.write(line.replaceAll(substr, replacement));
                writer.write("\n");

            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //3. В каждой строке найти слова, начинающиеся с гласной буквы.
    public static void searchWordsThatStartsWithVowels() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));
        ) {
            StringBuffer words = new StringBuffer();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                Pattern pattern = Pattern.compile("\\b[aoueiy][a-z,']*", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    words.append(matcher.group());
                    words.append(" ");
                }


            }
            System.out.println(words);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //4. Найти и вывести слова текста, для которых последняя буква одного слова совпадает с первой буквой следующего слова.
    public static void showWords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));) {
            ArrayList<String> words = new ArrayList<>();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                line = line.replaceAll(",", " ")
                        .replaceAll(" +", " ");
                words.addAll(Arrays.asList(line.split(" ")));
            }

            for (int i = 0; i < words.size() - 2; i++) {
                if (words.get(i).toCharArray()[words.get(i).length() - 1] == words.get(i + 1).toCharArray()[0]) {
                    System.out.println(words.get(i) + " " + words.get(i + 1));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //5. Найти в каждой строке самое длинное и самое короткое слово.
    public static void searchLongAndShort() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));
        ) {
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                String max = "0";
                String min = "0";
                String words[] = line.split(" ");
                for (String word : words) {
                    min = words[0];
                    max = words[0];
                    if (word.length() > max.length()) {
                        max = word;
                    } else if (word.length() < min.length()) {
                        min = word;
                    }
                }
                System.out.println("max " + max + " min " + min);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //6.В каждой строке подсчитать частоту повторяемости каждого слова из заданного списка
    // и вывести эти слова в порядке возрастания частоты повторяемости.

    private static void searchRepeats(String words[]) {
        try (BufferedReader reader = new BufferedReader(new FileReader(SRC))) {
            int amounts[] = new int[words.length];
            while (true) {
                String line = reader.readLine();
                if (line == null) break;

                for (int i = 0; i < words.length; i++) {
                    Pattern pattern = Pattern.compile(words[i]);
                    Matcher matcher = pattern.matcher(line);

                    while (matcher.find()) {
                        amounts[i]++;
                    }
                }
            }
            //sort
            boolean isSorted = false;
            int t=0;
            String temp="";
            while (!isSorted) {
                for (int i = 0; i < words.length-1; i++) {
                    if (amounts[i]>amounts[i+1]){
                        t = amounts[i];
                        amounts[i] = amounts[i + 1];
                        amounts[i + 1] = t;

                        temp = words[i];
                        words[i] = words[i + 1];
                        words[i + 1] = temp;
                    } else {isSorted=true;}
                }
            }

            for (int i=0; i<words.length;i++){
                System.out.println(words[i]+" - "+amounts[i]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //7. В каждом слове заменить первую букву слова на прописную.

    private static void changeToUpperCase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));
             BufferedWriter writer = new BufferedWriter(new FileWriter(COPY3))) {

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

    //8.Определить частоту повторяемости букв и слов в тексте.

    private static void countRepeats(String word, char letter) {

        try (BufferedReader reader = new BufferedReader(new FileReader(SRC))) {
            int counterWord = 0;
            int counterLetter = 0;
            while (true) {
                String line = reader.readLine();
                if (line == null) break;

                Pattern patternWord = Pattern.compile(word);
                Pattern patternLetter = Pattern.compile(String.valueOf(letter));
                Matcher matcherWord = patternWord.matcher(line);
                Matcher matcherLetter = patternLetter.matcher(line);

                while (matcherWord.find()) {
                    counterWord++;
                }
                while (matcherLetter.find()) {
                    counterLetter++;
                }
            }
            System.out.println("Word " + counterWord + " Letter " + counterLetter);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
