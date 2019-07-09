package HomeTask.FIfthTask;

import java.io.*;

public class Task3 {

    public static void main(String[] args) {
        searchWordsStartingWithAVowel();
    }

    public static void searchWordsStartingWithAVowel(){

        char[] vowels = "eyuioa".toCharArray();

        try (BufferedReader br = new BufferedReader(new FileReader("kosenkov-ihor/src/main/resources/song.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("kosenkov-ihor/src/main/resources/song_copy.txt"))) {

            while (true){
                String string = br.readLine();
                if (string == null) break;
                String[] words = string.split("[\\s|,]");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].isEmpty()) continue;
                    for (char vowel : vowels) {
                        if (vowel == words[i].toLowerCase().charAt(0)) {
                            bw.write(words[i]);
                            bw.newLine();
                        }
                    }
                }
            }
            bw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
