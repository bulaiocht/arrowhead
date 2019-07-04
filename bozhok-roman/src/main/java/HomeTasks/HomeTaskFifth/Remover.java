package HomeTasks.HomeTaskFifth;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Remover {

    public static void main(String[] args) {

        deleteSubString("du");

    }
    /**
    1.  В каждой строке найти и  удалить заданную подстроку.
     **/
    private static void deleteSubString(String text){
        try (BufferedReader reader= new BufferedReader(new FileReader(Path.SRC.getPath()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Path.COPY.getPath()))){
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                writer.write(line.replaceAll(text,""));
                writer.newLine();
            }
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();

        }


    }


}
