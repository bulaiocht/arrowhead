package io.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class FilesClassExample {

    public static void main(String[] args) {

//        Path path = Paths.get("examples/src/main/resources/", "song.txt");
//        Path pathTarget = Paths.get("examples/src/main/resources/", "song_copy.txt");
//        System.out.println("Exists: " + Files.exists(path));
//        System.out.println("Is dir: " + Files.isDirectory(path));
//        System.out.println("Is executable: "+ Files.isExecutable(path));
//        System.out.println("Is readable: "+  Files.isReadable(path));
//        System.out.println("Is file: "  + Files.isRegularFile(path));
//
//        try {
//            Files.copy(path, pathTarget, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String dude = "https://media.wired.com/photos/598e35fb99d76447c4eb1f28/master/pass/phonepicutres-TA.jpg";

        final Path copy = Paths.get("dude_copy.jpg");

        try {

            URL dudeUrl = new URL(dude);
            InputStream dudeIs = dudeUrl.openStream();
            Files.copy(dudeIs, copy, StandardCopyOption.REPLACE_EXISTING);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


//        MyFileVisitor myFileVisitor = new MyFileVisitor();
//
//        try {
//            Files.walkFileTree(dirTree, myFileVisitor);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        List<Path> textFiles = myFileVisitor.getTextFiles();
//
//        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("text_files.zip"))) {
//
//            textFiles
//                    .forEach(text -> {
//
//                        try(FileInputStream fis = new FileInputStream(text.toFile())) {
//
//                            zos.putNextEntry(new ZipEntry(text.toFile().getName()));
//                            byte[] bytes = Files.readAllBytes(text);
//                            zos.write(bytes);
//                            zos.flush();
//                            zos.closeEntry();
//
//                        } catch(IOException e) {
//                            System.err.println(e.getMessage());
//                        }
//
//                    });
//
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//
//        try {
//            ZipFile zipFile = new ZipFile("text_files.zip");
//
//            Enumeration<? extends ZipEntry> entries = zipFile.entries();
//            while (entries.hasMoreElements()) {
//                ZipEntry entry = entries.nextElement();
//                System.out.println(entry.getName());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
