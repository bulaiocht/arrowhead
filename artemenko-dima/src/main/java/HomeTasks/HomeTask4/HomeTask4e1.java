package HomeTasks.HomeTask4;

import java.io.*;
import java.util.Scanner;

//1.  В каждой строке найти и  удалить заданную подстроку.
public class HomeTask4e1 {
    public static void main(String[] args) throws IOException {

        System.out.print("What you need to delete: ");
        Scanner sc = new Scanner(System.in);
        String remove = sc.nextLine();

        InputStream bookIn = new BufferedInputStream(new FileInputStream("artemenko-dima\\src\\main\\resources\\book.txt"));

        if (bookIn != null) {

            try (BufferedOutputStream bookOut = new BufferedOutputStream(new FileOutputStream("artemenko-dima\\src\\main\\resources\\book_copy1.txt"))){

                Scanner scanner = new Scanner(bookIn);
                StringBuffer text = new StringBuffer();

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    text.append(line.replaceAll(remove, ""));
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