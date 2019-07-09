package HomeTask.FIfthTask;

import java.io.*;
import java.util.Arrays;

public class Task6 {

    public static void main(String[] args) {
        findFrequencyOfOccurrenceWords(new String[]{"believer", "pain", "writing", "you", "made"});
    }

    public static void findFrequencyOfOccurrenceWords(String[] arr){

        try (BufferedReader br = new BufferedReader(new FileReader("kosenkov-ihor/src/main/resources/song.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("kosenkov-ihor/src/main/resources/song_copy.txt"))) {

            int[] count = new int[arr.length];

            while (true){
                String string = br.readLine();
                if (string == null) break;
                if (string.isEmpty()) continue;
                String[] words = string.split("[\\s|,|!|.]");
                for (int i = 0; i < words.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (words[i].toLowerCase().equals(arr[j])) count[j]++;
                    }
                }
            }

            //сортируем слова по частоте повторяемости
            boolean isSorted = false;
            int buf;
            String bufString;
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < count.length-1; i++) {
                    if(count[i] > count[i+1]){
                        isSorted = false;

                        buf = count[i];
                        count[i] = count[i+1];
                        count[i+1] = buf;

                        bufString = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = bufString;
                    }
                }
            }
            //вывдоим слова
            for (int i = 0; i < count.length; i++) {
                bw.write(String.format("%s with %d occurrence \n", arr[i], count[i]));
                bw.newLine();
                System.out.printf("%s with %d occurrence \n", arr[i], count[i]);
            }
            bw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
