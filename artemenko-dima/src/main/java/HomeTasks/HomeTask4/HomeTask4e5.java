package HomeTasks.HomeTask4;

import java.io.*;
import java.util.Scanner;

//5.  Найти в каждой строке самое длинное и самое короткое слово.
public class HomeTask4e5 {
    public static void main(String[] args) throws IOException {

        InputStream bookIn = new BufferedInputStream(
                new FileInputStream("artemenko-dima\\src\\main\\resources\\book.txt"));

        if (bookIn != null) {

            Scanner scanner = new Scanner(bookIn);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                shortAndLongWord(line);
            }
        }
    }

    static void shortAndLongWord(String str)
    {
        if (str == null)
            return;
        String sw="",lw="";
        int s=str.length(),l=0;
        String words[]=str.split(" ");
        for(String word:words)
        {
            if(word.length()<s)
            {
                sw=word;
                s = word.length();
            }
            if(word.length()>l)
            {
                lw=word;
                l = word.length();
            }
        }
        System.out.print("LONGEST WORD : " + lw + "; ");
        System.out.println("SHORTEST WORD : " + sw + ";");
    }
}
