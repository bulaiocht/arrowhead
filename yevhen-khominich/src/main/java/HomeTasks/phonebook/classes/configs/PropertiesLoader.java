<<<<<<< HEAD
package HomeTasks.phonebook.classes.configs;
=======
package classes.configs;
>>>>>>> yevhen-khominich

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties(String pathToProperties) {
        try {
            FileInputStream in = new FileInputStream(pathToProperties);
            Properties properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException e) {
            return null;
        }
    }

}

