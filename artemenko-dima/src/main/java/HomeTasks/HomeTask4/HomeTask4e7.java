package HomeTasks.HomeTask4;

import java.io.*;
import java.util.Scanner;
//7.  В  каждом  слове  заменить  первую  букву  слова на  прописную.
public class HomeTask4e7 {
    public static void main(String[] args) throws IOException {

        InputStream bookIn = new BufferedInputStream(
                new FileInputStream("artemenko-dima\\src\\main\\resources\\book.txt"));

        if (bookIn != null) {

            try (BufferedOutputStream bookOut = new BufferedOutputStream(
                    new FileOutputStream("artemenko-dima\\src\\main\\resources\\book_copy7.txt"))){

                Scanner scanner = new Scanner(bookIn);
                StringBuffer text = new StringBuffer();

                while (scanner.hasNext()) {
                    String line = scanner.next();
                    text.append(firstUpperCase(line) + " ");
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
    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
