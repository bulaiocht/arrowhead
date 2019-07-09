package HomeTask.FIfthTask;

import java.io.*;

public class Task5 {

    public static void main(String[] args) {
        findTheMostShortestAndLongestWords();
    }

    public static void findTheMostShortestAndLongestWords(){

        try (BufferedReader br = new BufferedReader(new FileReader("kosenkov-ihor/src/main/resources/song.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("kosenkov-ihor/src/main/resources/song_copy.txt"))) {

            while (true){
                String string = br.readLine();
                if (string == null) break;
                if (string.isEmpty()) continue;
                String[] words = string.split("[\\s|,|!|.]");
                String shortestWord = words[0];
                String longestWord = words[0];
                for (int i = 1; i < words.length; i++) {
                    if (words[i].isEmpty()) continue;
                    if (words[i].length()<shortestWord.length()) shortestWord = words[i];
                    if (words[i].length()>longestWord.length()) longestWord = words[i];
                }
                bw.write(String.format("Shortest word: %s, longest word: %s.", shortestWord,longestWord));
                bw.newLine();
                System.out.printf("Shortest word: %s, longest word: %s.", shortestWord,longestWord);
                System.out.println();

            }
            bw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
