package HW06;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeID {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/katya/IdeaProjects/hillel-homeworks/src/main/java/HW06/IDbase.txt");
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        String ids;

        System.out.println("Valid employee IDs:");
        while ((ids = reader.readLine()) != null) {
            Pattern pattern = Pattern.compile("\\b((([1-9]\\d)|(1[0-4]\\d))\\s\\d{3}\\s\\d{3})|(150\\s000\\s000)");
            Matcher matcher = pattern.matcher(ids);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}