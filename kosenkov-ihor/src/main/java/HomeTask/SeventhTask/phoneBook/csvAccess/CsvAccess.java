package HomeTask.SeventhTask.phoneBook.csvAccess;

import java.io.*;

public class CsvAccess {

    String pass = "kosenkov-ihor/src/main/java/HomeTask/SeventhTask/phoneBook/resources/phone_book.csv";

    public String readLines() {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pass))) {
            StringBuilder contacts = new StringBuilder("");
            bufferedReader.lines().forEach(s -> contacts.append(s).append("\n"));
            return contacts.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeLines(String contacts) {

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pass))) {
            String[] strings = contacts.split("\n");
            for (String string : strings) {
                bufferedWriter.write(string + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
