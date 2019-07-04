package HomeTasks.HomeTaskFifth;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher {
    public static void main(String[] args) {
        searchTwoWord();

    }
    /**
     4.  Найти  и  вывести  слова  текста,  для  которых
     последняя  буква  одного  слова совпадает с  первой буквой следующего слова.
     **/

    private static void searchTwoWord(){
        try (BufferedReader reader= new BufferedReader(new FileReader(Path.SRC.getPath()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Path.COPY.getPath()))){


            String lastleter = "";
            String word ="";
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                Pattern pattern = Pattern.compile("\\b([a-z]{1,})\\b",Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String[] s1 = (matcher.group().toLowerCase()).split("");

                    if (lastleter.equals(s1[0])){
                        writer.write(word+" , "+matcher.group()+"\n");

                    }
                    word=matcher.group();
                    lastleter = s1[s1.length-1];

                }




            }
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();

        }


    }
}
