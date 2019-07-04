package HomeTasks.HomeTaskFifth;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinderCounterWords {
    public static void main(String[] args) {

        String[] s1 = new String[]{"hast","du","da","ich"};
        findCountLetterWord(s1);

    }
    /**
     6.  В каждой  строке  подсчитать  частоту  повторяемости
     каждого  слова  из  заданного  списка  и  вывести  эти  слова
     в  порядке возрастания частоты повторяемости.
     **/

    private static void findCountLetterWord(String[] words){
        try (BufferedReader reader= new BufferedReader(new FileReader(Path.SRC.getPath()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(Path.COPY.getPath()))){


            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                Pattern pattern = Pattern.compile("\\b([a-z]{1,})\\b",Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                int[] countWord = new int[words.length];
                while (matcher.find()) {

                    for (int i = 0; i < words.length; i++) {
                        if ((matcher.group().toLowerCase()).equals(words[i])){

                            countWord[i]++;
                        }
                    }
                }
                int i = 0;

                StringBuilder stringBuilder = new StringBuilder();

                int [] sort = countWord.clone();
                Arrays.sort(sort);
                while (true){
                    for (int i1 = 0; i1 < countWord.length; i1++) {
                        if (sort[i]==countWord[i1]){
                            stringBuilder.append(countWord[i1] + " - " + words[i1] + " ");
                            i++;
                            if (i==countWord.length){
                                i1= countWord.length+1;
                            }

                    }
                }
                if (i==countWord.length){
                    break;
                 }
                }

                writer.write(stringBuilder.toString());
                writer.newLine();



            }
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();

        }


    }
}
