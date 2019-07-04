package HomeTasks.HomeTaskFifth;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinderCount {
    public static void main(String[] args) {

        findCountLetterWord("u","du");

    }
    /**
     8.  Определить частоту повторяемости букв и слов в тексте.
     **/

    private static void findCountLetterWord(String letter,String word){
        try (BufferedReader reader= new BufferedReader(new FileReader(Path.SRC.getPath()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Path.COPY.getPath()))){


            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                Pattern pattern = Pattern.compile("\\b([a-z]{1,})\\b",Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                int countLetter = 0;
                int countWord = 0;
                while (matcher.find()) {
                    String s1 = matcher.group().toLowerCase();
                    String [] arrs  = s1.split("");
                    if (s1.equals(word)){
                        countWord++;
                    }
                    for (String arr : arrs) {
                        if(arr.equals(letter)){
                            countLetter++;
                        }
                    }
                }
                writer.write(line+" | "+ letter + " Count: "+countLetter +" ; "+
                    word+" Count: "+countWord) ;

                writer.newLine();


            }
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();

        }


    }
}
