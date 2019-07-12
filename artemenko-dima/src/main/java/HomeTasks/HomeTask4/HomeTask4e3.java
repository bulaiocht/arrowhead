package HomeTasks.HomeTask4;

import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//3.  В каждой строке найти слова, начинающиеся с  гласной буквы.
public class HomeTask4e3 {
    public static void main(String[] args) throws IOException {

        InputStream bookIn = new BufferedInputStream(new FileInputStream("artemenko-dima\\src\\main\\resources\\book.txt"));

        if (bookIn != null) {

            try (BufferedOutputStream bookOut = new BufferedOutputStream(new FileOutputStream("artemenko-dima\\src\\main\\resources\\book_copy3.txt"))){

                Scanner scanner = new Scanner(bookIn);
                StringJoiner text = new StringJoiner(", ", "", " ");
                Pattern regex = Pattern.compile("\\b[aeyuio]\\w+");


                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    Matcher matcher = regex.matcher(line);
                    while (matcher.find()) {
                        text.add(matcher.group());
                    }
                }

                bookOut.write(text.toString().getBytes());
                bookOut.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bookIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
