package HomeTasks.HomeTaskSeventh.PhoneBook.classes.readerConfig;

import java.io.*;
import java.util.Properties;

public abstract class PropertiesLoader {
    private static final Properties PATHCONFIG = loader();
    public static final String REGEXNAME = PATHCONFIG.getProperty("REGEXNAME");
    public static final String REGEXNUMBER = PATHCONFIG.getProperty("REGEXNUMBER");
    public static final String REGEXEMAIL= PATHCONFIG.getProperty("REGEXEMAIL");
    public static final String PATHPHONEBOOK= PATHCONFIG.getProperty("PATHPHONEBOOK");

    private static Properties loader (){
        try {
            FileInputStream in = new FileInputStream(
                    String.format("bozhok-roman" +
                                    "%ssrc" +
                                    "%smain" +
                                    "%sresources" +
                                    "%sconfigurationPhoneBook" +
                                    "%sPhoneBookConfig.properties",
                            File.separator,
                            File.separator,
                            File.separator,
                            File.separator,
                            File.separator));
            Properties properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException e) {
            return null;
        }
    }

}
