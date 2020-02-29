package HomeTasks.SimpleRegistration.validation;

import HomeTasks.phonebook.classes.configs.EmailConfig;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean checkEmail(String email){
        Pattern regex = Pattern.compile("[^@]+@[^\\.]+\\.[a-z]{2,6}$");
        Matcher matcher = regex.matcher(email);
        return matcher.find();
    }
}
