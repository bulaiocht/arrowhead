package HomeTasks.HomeTask4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//6.  В каждой  строке
// подсчитать  частоту  повторяемости  каждого  слова из  заданного  списка
// и  вывести  эти  слова  в  порядке возрастания частоты повторяемости.
public class HomeTask4e6 {
    public static void main(String[] args) throws IOException {

        String [] arrayWords = new String[3];

        for (int i =0; i < arrayWords.length; i++) {
            System.out.print("What word to find: ");
            Scanner sc = new Scanner(System.in);
            arrayWords[i] = sc.nextLine();
        }

        int[] counters = new int[arrayWords.length];

        InputStream bookIn = new BufferedInputStream(
                new FileInputStream("artemenko-dima\\src\\main\\resources\\book.txt"));

        if (bookIn != null) {

                Scanner scanner = new Scanner(bookIn);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Pattern pattern = Pattern.compile("(\\b([A-Za-z]+)\\b)");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {

                    for (int i = 0; i < arrayWords.length; i++) {
                        if ((matcher.group().toLowerCase()).equals(arrayWords[i])) {
                            counters[i]++;
                        }
                    }
                }
            }
            sortAndShow(counters, arrayWords);
        }
    }
    private static void sortAndShow(int[] counters, String[] words) {

        boolean isSorted = false;
        int temp;
        String temp2;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < counters.length - 1; i++) {
                if (counters[i] > counters[i + 1]) {
                    isSorted = false;

                    temp = counters[i];
                    counters[i] = counters[i + 1];
                    counters[i + 1] = temp;

                    temp2 = words[i];
                    words[i] = words[i + 1];
                    words[i + 1] = temp2;
                }
            }
        }
        for (int i = 0; i < counters.length; i++) {
            System.out.println("Word " + "\"" + words[i] + "\"" + " Number of matches " + counters[i]);
        }
    }
}
