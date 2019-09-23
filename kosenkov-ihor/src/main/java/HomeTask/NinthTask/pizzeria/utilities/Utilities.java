package HomeTask.NinthTask.pizzeria.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    public static boolean isValidOrder(String order){
        Pattern pattern = Pattern.compile("(\\b[1-4]\\:\\d{1,2}\\b)");
        Matcher matcher = pattern.matcher(order);
        return matcher.find();
    }

}
