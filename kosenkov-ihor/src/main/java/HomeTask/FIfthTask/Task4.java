package HomeTask.FIfthTask;

import java.io.*;

public class Task4 {

    public static void main(String[] args) {
        findTwoWords();
    }

    public static void findTwoWords(){
        try (BufferedReader br = new BufferedReader(new FileReader("kosenkov-ihor/src/main/resources/song.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("kosenkov-ihor/src/main/resources/song_copy.txt"))) {

            char lastLetter;
            String previousWord;

            while (true){
                String string = br.readLine();
                if (string == null) break;
                String[] words = string.split("[\\s|,]");
                if (string.isEmpty()) continue;
                lastLetter = words[0].charAt(words[0].length()-1);
                previousWord = words[0];
                for (int i = 1; i < words.length; i++) {
                    if (words[i].isEmpty()) continue;
//                    System.out.println(previousWord + " " + words[i]);
                    if (words[i].toLowerCase().charAt(0)==lastLetter){
                        System.out.println(previousWord + " " + words[i]);
                        bw.write(previousWord + " " + words[i]);
                        bw.newLine();
                    }
                    lastLetter = words[i].charAt(words[i].length()-1);
                    previousWord = words[i];
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
