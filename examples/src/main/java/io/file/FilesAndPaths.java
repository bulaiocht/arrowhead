package io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FilesAndPaths {

    private static final String SRC_PATH = "examples/src/main/resources/";
    private static final String TXT = "song.txt";
    private static final String SH = "executable.sh";
    private static final String DIR = "dir";
    private static final String DIR_LINK = "dir_link";

    public static void main(String[] args) {

        boolean b = null instanceof Number;

        System.out.println(b);

        String url = "https://media.wired.com/photos/598e35994ab8482c0d6946e0/master/w_582,c_limit/phonepicutres-TA.jpg";

//        downloadFile(url);
//
//        classPathResource();

//        filesAndPaths(SRC_PATH + TXT);
//        filesAndPaths(SRC_PATH + SH);
//        filesAndPaths(SRC_PATH + DIR);
//        filesAndPaths(SRC_PATH + DIR_LINK);
        visitDir(Paths.get(SRC_PATH, "dir"));

//        filesAndPaths("kek");

    }

    private static void downloadFile(String url) {

        try {
            URI picture = new URI(url);

            URL pictureUrl = picture.toURL();

            try (BufferedInputStream bis = new BufferedInputStream(pictureUrl.openStream());
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("pic.jpg"))) {
                while (true) {
                    final int read = bis.read();
                    if (read == -1) break;
                    bos.write(read);
                }
                bos.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        } catch (URISyntaxException | MalformedURLException e) {
            System.err.println(e.getMessage());
        }

    }

    private static void classPathResource() {
        Class<FilesAndPaths> filesAndPathsClass = FilesAndPaths.class;

        ClassLoader classLoader = filesAndPathsClass.getClassLoader();

        URL resource = classLoader.getResource("song.txt");

        Objects.requireNonNull(resource, "Input stream is null");

        String file = resource.getFile();

        System.out.println(file);
    }

    private static void filesAndPaths(String path) {

        File file = new File(path);

        Path filePath = Paths.get(path);

        oldWay(file);

        try {
            newWay(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void oldWay(File file) {
        System.out.println("Old Way");
        System.out.printf("It exists: %s\n", file.exists());
        System.out.printf("Is directory: %s\n", file.isDirectory());
        System.out.printf("Is file: %s\n", file.isFile());
        System.out.printf("It's name: %s\n", file.getName());
        System.out.printf("Is executable: %s\n", file.canExecute());
        System.out.printf("Is readable: %s\n", file.canRead());
        System.out.printf("Is writable: %s\n", file.canWrite());
        System.out.println("==============");
    }

    private static void newWay(Path path) throws IOException {
        System.out.println("New Way");
        System.out.printf("It exists: %s\n", Files.exists(path));
        System.out.printf("Is directory: %s\n", Files.isDirectory(path));
        System.out.printf("Is regular file: %s\n", Files.isRegularFile(path));
        System.out.printf("It's name: %s\n", path.toFile().getName());
        System.out.printf("Is executable: %s\n", Files.isExecutable(path));
        System.out.printf("Is readable: %s\n", Files.isReadable(path));
        System.out.printf("Is writable: %s\n", Files.isWritable(path));
        System.out.printf("Is symbolic link: %s\n", Files.isSymbolicLink(path));
        System.out.printf("Last modified: %s\n", Files.getLastModifiedTime(path, LinkOption.NOFOLLOW_LINKS).toString());

        System.out.println("==============");

    }

    private static void visitDir(Path path) {
        try {
            Files.find(path, 50, (path1, attributes) ->  {
                File f = path1.toFile();
                return f.getName().contains("11");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
