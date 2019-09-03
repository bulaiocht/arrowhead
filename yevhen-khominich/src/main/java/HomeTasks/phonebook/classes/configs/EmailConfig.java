
package HomeTasks.phonebook.classes.configs;


import java.io.File;
import java.util.Properties;

public class EmailConfig {

    final private static String PATH_TO_EMAIL_PROPERTIES = String.format
            (
                            "src" +
                            "%smain" +
                            "%sresources" +
                            "%sproperties" +
                            "%semail.properties",
                    File.separator,
                    File.separator,
                    File.separator,
                    File.separator,
                    File.separator);


    final public static Properties EMAIL_PROPERTIES = PropertiesLoader.loadProperties(PATH_TO_EMAIL_PROPERTIES);
    final public static String USER = EMAIL_PROPERTIES.getProperty("mail.smtp.user");
    final public static String PASS = EMAIL_PROPERTIES.getProperty("mail.smtp.pass");
    final public static String MESSAGE_SUBJECT = EMAIL_PROPERTIES.getProperty("message.subject");
    final public static String MESSAGE_TEXT = EMAIL_PROPERTIES.getProperty("message.text");
    final public static String MESSAGE_FILE_NAME = EMAIL_PROPERTIES.getProperty("message.fileName");
    final public static String REGEX_MAIL = EMAIL_PROPERTIES.getProperty("regex.mail");


}
