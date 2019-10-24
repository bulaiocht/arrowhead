package io.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyFileVisitor implements FileVisitor<Path> {

    private List<Path> textFiles = new ArrayList<>();

    @Override
    public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
        String name = file.toFile().getName();
        if (name.endsWith(".txt"))
            System.out.println("Txt file found! " + file.toFile().getAbsolutePath());
        textFiles.add(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(final Path file, final IOException exc) throws IOException {
        System.err.println(exc.getMessage());
        return FileVisitResult.SKIP_SUBTREE;
    }

    @Override
    public FileVisitResult postVisitDirectory(final Path dir, final IOException exc) throws IOException {
        System.out.println("Bye bye directory: " + dir.toFile().getName());
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getTextFiles() {
        return textFiles;
    }
}
