package HomeTasks.HomeTask4;

import java.io.*;
import java.util.Scanner;

//2.  В  каждой  строке  стихотворения  найти  и  заменить  заданную  подстроку на  подстроку иной длины.
public class HomeTask4e2 {
    public static void main(String[] args) throws IOException {

        System.out.print("What word should be replaced: ");
        Scanner sc1 = new Scanner(System.in);
        String remove = sc1.nextLine();
        System.out.print("What word to replace: ");
        Scanner sc2 = new Scanner(System.in);
        String replacement = sc2.nextLine();

        InputStream bookIn = new BufferedInputStream(
                new FileInputStream("artemenko-dima\\src\\main\\resources\\book.txt"));

        if (bookIn != null) {

            try (BufferedOutputStream bookOut = new BufferedOutputStream(
                    new FileOutputStream("artemenko-dima\\src\\main\\resources\\book_copy2.txt"))){

                Scanner scanner = new Scanner(bookIn);
                StringBuffer text = new StringBuffer();

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    text.append(line.replaceAll(remove, replacement));
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
