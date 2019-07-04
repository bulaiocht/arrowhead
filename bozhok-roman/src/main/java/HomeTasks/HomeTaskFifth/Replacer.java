package HomeTasks.HomeTaskFifth;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacer {

    public static void main(String[] args) {

        replaceSubString("no","nia");

    }
    /**
     2.  В  каждой  строке  стихотворения  найти
     и  заменить  заданную  подстроку на  подстроку иной длины.
     **/

    private static void replaceSubString(String text1,String text2){
        try (BufferedReader reader= new BufferedReader(new FileReader(Path.SRC.getPath()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Path.COPY.getPath()))){
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                writer.write(line.replaceAll(text1,text2));
                writer.newLine();
            }
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();

        }


    }
}
