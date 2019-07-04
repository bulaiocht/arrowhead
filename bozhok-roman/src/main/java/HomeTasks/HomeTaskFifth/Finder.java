package HomeTasks.HomeTaskFifth;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {

    public static void main(String[] args) {

        findWord();

    }
    /**
     3.  В каждой строке найти слова, начинающиеся с  гласной буквы.
     **/

    private static void findWord(){
        try (BufferedReader reader= new BufferedReader(new FileReader(Path.SRC.getPath()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Path.COPY.getPath()))){
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                Pattern pattern = Pattern.compile("\\b([aeiouyj][a-z]{1,})\\b",Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    writer.write(matcher.group()+" ");

                }
                writer.newLine();


            }
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();

        }


    }
}
