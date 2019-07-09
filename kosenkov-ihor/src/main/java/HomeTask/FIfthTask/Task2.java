package HomeTask.FIfthTask;

import java.io.*;

public class Task2 {

    public static void main(String[] args) {

        replace("believer", "dreamer");

    }

    public static void replace(String srcSubstring, String substring){

        try (BufferedReader br = new BufferedReader(new FileReader("kosenkov-ihor/src/main/resources/song.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("kosenkov-ihor/src/main/resources/song_copy.txt"))) {

            while (true){
                String string = br.readLine();
                if (string == null) break;
                bw.write(string.replaceAll(srcSubstring, substring));
                bw.newLine();
                if (string.contains(srcSubstring)) {
                    System.out.println("Было: " + string);
                    System.out.println("Стало: " + string.replaceAll(srcSubstring, substring));
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
