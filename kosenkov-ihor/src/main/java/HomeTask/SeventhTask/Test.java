package HomeTask.SeventhTask;

import HomeTask.SeventhTask.phoneBook.csvAccess.CsvAccess;
import HomeTask.SeventhTask.phoneBook.service.Service;

import javax.crypto.spec.PSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Test {

    public static void main(String[] args){

        Locale[] locales = {
                Locale.FRENCH,
                Locale.ENGLISH,
                Locale.GERMAN
        };
        for (int i = 0; i < locales.length; i++) {
            displayValue(locales[i], "s2");
        }

        System.out.println();

        iterateKeys(locales[0]);

    }

    private static void displayValue(Locale currentLocale, String key) {
        ResourceBundle labels = ResourceBundle.getBundle("phonebook", currentLocale);

        String value = labels.getString(key);
        System.out.println("Locale = " + currentLocale.toString() + ", " +
                "Key = " + key + ", " +
                "value = " + value);
    }

    private static void iterateKeys(Locale currentLocale){
        ResourceBundle labels = ResourceBundle.getBundle("phonebook", currentLocale);
        Enumeration bundleKeys = labels.getKeys();

        while (bundleKeys.hasMoreElements()){
            String key = (String)bundleKeys.nextElement();
            String value = labels.getString(key);
            System.out.println("key = " + key + ", value = " + value);
        }
    }

    private static void propertiesExample() {
        Properties property = new Properties();

        try (FileInputStream fis = new FileInputStream("kosenkov-ihor/src/main/java/HomeTask/SeventhTask/phoneBook/resources/config.properties")){
            property.load(fis);

            String host = property.getProperty("db.host");
            String login = property.getProperty("db.login");
            String password = property.getProperty("db.password");

            System.out.println("HOST: " + host
                    + ", LOGIN: " + login
                    + ", PASSWORD: " + password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void csvExample() {

    }

}
