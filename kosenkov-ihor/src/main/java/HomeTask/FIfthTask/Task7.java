package HomeTask.FIfthTask;

import java.io.*;

public class Task7 {

    public static void main(String[] args) {
        replaceCapitalLetter();
    }

    public static void replaceCapitalLetter(){
        try (BufferedReader br = new BufferedReader(new FileReader("kosenkov-ihor/src/main/resources/song.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("kosenkov-ihor/src/main/resources/song_copy.txt"))) {

            while (true){
                String string = br.readLine();
                if (string == null) break;
                if (string.isEmpty()) {
                    bw.newLine();
                    continue;
                }
                String[] words = string.split("[\\s|]");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].isEmpty())continue;
                    String newWord = words[i].substring(0,1).toUpperCase() + words[i].substring(1);
                    bw.write(newWord+" ");

                }
                bw.newLine();
            }
            bw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
