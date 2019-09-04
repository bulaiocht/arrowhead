
package HomeTasks.phonebook.classes.configs;


import java.io.File;
import java.util.Properties;

public class PhoneBookConfig {

    final private static String PATH_TO_PHONEBOOK_PROPERTIES = String.format
            (
                    "yevhen-khominich" +
                            "%ssrc" +
                            "%smain" +
                            "%sresources" +
                            "%sproperties" +
                            "%sphonebook.properties",

                    File.separator,
                    File.separator,
                    File.separator,
                    File.separator,
                    File.separator);



    final public static Properties PHONEBOOK_PROPERTIES = PropertiesLoader.loadProperties(PATH_TO_PHONEBOOK_PROPERTIES);
    final public static String HEADER = PHONEBOOK_PROPERTIES.getProperty("menu.header");
    final public static String MENU_MESSAGE1 = PHONEBOOK_PROPERTIES.getProperty("menu.message1");
    final public static String MENU_MESSAGE2 = PHONEBOOK_PROPERTIES.getProperty("menu.message2");
    final public static String MENU_MESSAGE3 = PHONEBOOK_PROPERTIES.getProperty("menu.message3");
    final public static String MENU_MESSAGE4 = PHONEBOOK_PROPERTIES.getProperty("menu.message4");
    final public static String MENU_MESSAGE5 = PHONEBOOK_PROPERTIES.getProperty("menu.message5");
    final public static String MENU_MESSAGE6 = PHONEBOOK_PROPERTIES.getProperty("menu.message6");
    final public static String MENU_MESSAGE7 = PHONEBOOK_PROPERTIES.getProperty("menu.message7");
    final public static String MENU_MESSAGE_CHOICE = PHONEBOOK_PROPERTIES.getProperty("menu.message.choice");
    final public static String PATH_TO_FILE=PHONEBOOK_PROPERTIES.getProperty("pathToFile");
    final public static String REGEX_NUMBER=PHONEBOOK_PROPERTIES.getProperty("regex.number");



}
