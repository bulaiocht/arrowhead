package io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SerializationExample {

    public static void main(String[] args) {

        serializationExample();

    }

    private static void serializationExample() {

        User user = new User("bill", "bill.email@email.com", "password1234");
        System.out.println(user);

        User.field = "hi there";

        File userFile = new File("user");

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(userFile))) {

            os.writeObject(user);

        } catch (FileNotFoundException e) {
            System.err.println("No such file found");
        } catch (IOException e) {
            System.err.println("Unable to save file");
        }

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(userFile))) {

            User deserializeUser = (User) is.readObject();
            System.out.println(deserializeUser);

        } catch (FileNotFoundException e) {
            System.err.println("No such file found");
        } catch (IOException e) {
            System.err.println("Unable to save file");
        } catch (ClassNotFoundException e) {
            System.err.println("No such class found");
        }


    }

}

