package HomeTask.FIfthTask;

import java.io.*;

public class Task1 {

    public static void main(String[] args) {
        deleteSubstring("believer");
    }

    public static void deleteSubstring(String substring){

        try (BufferedReader br = new BufferedReader(new FileReader("kosenkov-ihor/src/main/resources/song.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("kosenkov-ihor/src/main/resources/song_copy.txt"))) {

            while (true){
                String string = br.readLine();
                if (string == null) break;
                bw.write(string.replaceAll(substring, ""));
                bw.newLine();
                if (string.contains(substring)) {
                    System.out.println("Было: " + string);
                    System.out.println("Стало: " + string.replaceAll(substring, ""));
                    System.out.println();
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
