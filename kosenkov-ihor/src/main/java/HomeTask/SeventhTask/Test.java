package HomeTask.SeventhTask;

import HomeTask.SeventhTask.phoneBook.csvAccess.CsvAccess;
import HomeTask.SeventhTask.phoneBook.service.Service;

import javax.crypto.spec.PSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Test {

    public static void main(String[] args){

        CsvAccess csvAccess =new CsvAccess();
        csvAccess.writeLines("ewq,1231");
//        propertiesExample();


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
