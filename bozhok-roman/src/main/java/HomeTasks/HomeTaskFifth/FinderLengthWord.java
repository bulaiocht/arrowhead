package HomeTasks.HomeTaskFifth;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinderLengthWord {

    public static void main(String[] args) {

        findShorAndLongWord();

    }
    /**
     5.  Найти в каждой строке самое длинное и самое короткое слово.
     **/

    private static void findShorAndLongWord(){
        try (BufferedReader reader= new BufferedReader(new FileReader(Path.SRC.getPath()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Path.COPY.getPath()))){

            int min = 100;
            int max = 0;
            String longWord = "";
            String shortWord = "";
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                Pattern pattern = Pattern.compile("\\b([a-z]{1,})\\b",Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String[] s1 = matcher.group().split("");
                    int length = s1.length;
                    if (length<min){
                        min = length;
                        shortWord=matcher.group();
                    }else if (length>max){
                        max = length;
                        longWord=matcher.group();
                    }

                }
                writer.write(shortWord+" , "+ longWord);
                writer.newLine();


            }
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();

        }


    }
}
