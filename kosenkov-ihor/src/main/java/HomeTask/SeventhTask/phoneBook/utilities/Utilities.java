package HomeTask.SeventhTask.phoneBook.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    public static boolean isValidContact(String contact) {
        if (!contact.contains(",")) return false;
        boolean result = isValidName(contact.substring(0, contact.indexOf(",")))
                && isValidNumber(contact.substring(contact.indexOf(",")+1));
        return result;
    }

    public static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("\\b[A-Za-z]{3,15}\\b");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public static boolean isValidNumber(String number) {
        Pattern pattern = Pattern.compile("\\B(\\+(\\d){1,3})(\\d{3})(\\d{7})\\b");
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }

}
