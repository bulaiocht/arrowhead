package HomeTask.FourthTask.task2;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindEmployeeIDs {

    public static void main(String[] args) {

        findEmployeeID("Валидные примеры: 11 304 982, 39 683 234, 139 920 393, 150 000 000\n" +
                "Невалидные примеры: 153 349 111, 053 394 111, 3 394 234, 89 909 98,  139 920 39332, we150 000 000");

    }

    public static void findEmployeeID(String text){

        Pattern find = Pattern.compile("((\\b([1-9]\\d)(\\s)(\\d{3})(\\s)(\\d{3}))\\b|" +
                "\\b(([1][0-4]\\d)(\\s)(\\d{3})(\\s)(\\d{3}))" +
                "|\\b(150 000 000))\\b");

        Matcher matcher = find.matcher(text);

        System.out.println("[Employee's IDs]");

        StringJoiner sj = new StringJoiner(", ", "[", "]");

        while (matcher.find()){

            sj.add(matcher.group().replace(" ", "_"));

        }

        System.out.println(sj);

    }

}
