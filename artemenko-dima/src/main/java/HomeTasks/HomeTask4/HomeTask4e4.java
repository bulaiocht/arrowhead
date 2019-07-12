package HomeTasks.HomeTask4;

import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//4.  Найти  и  вывести  слова  текста,  для  которых  последняя  буква  одного  слова совпадает с  первой буквой следующего слова.
public class HomeTask4e4 {
    public static void main(String[] args) throws IOException {
        InputStream bookIn = new BufferedInputStream(new FileInputStream("artemenko-dima\\src\\main\\resources\\book.txt"));

        if (bookIn != null) {
            Scanner scanner = new Scanner(bookIn);
            String line1 = scanner.next();

            while (scanner.hasNext()) {

                String line2 = scanner.next();

                if (line1.charAt(line1.length() - 1) == line2.charAt(0)){
                    System.out.println(line1  + " = " + line2);
                }
                line1 = line2;
            }
        }
    }
}

