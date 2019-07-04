package HomeTasks.HomeTaskFifth;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Changer {
    public static void main(String[] args) {

        changeFirstLaterInWord();

    }
    /**
     7.  В  каждом  слове  заменить  первую  букву  слова на  прописную.
     **/

    private static void changeFirstLaterInWord(){
        try (BufferedReader reader= new BufferedReader(new FileReader(Path.SRC.getPath()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Path.COPY.getPath()))){


            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                Pattern pattern = Pattern.compile("\\b([a-z]{1,})\\b",Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                String line1 = line;
                while (matcher.find()) {

                    String [] arrs  = matcher.group().split("");

                        arrs[0]=arrs[0].toUpperCase();



                    line1 = line1.replace(""+matcher.group(),""+String.join("", arrs));

                }

                writer.write(line1);

                writer.newLine();


            }
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();

        }


    }
}
