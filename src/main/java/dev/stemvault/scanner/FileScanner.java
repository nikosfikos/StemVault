package dev.stemvault.scanner;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class FileScanner {

    public ArrayList<Path> scan(Path path) throws IOException {
        ArrayList<Path> paths = new ArrayList<>();
        SimpleFileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(
                Path file,
                BasicFileAttributes attrs
            ) throws IOException {
                for (AudioExtension extension : AudioExtension.values()) {
                    String tmp = file.getFileName().toString().toLowerCase();
                    if (tmp.endsWith(extension.getExtension())) {
                        paths.add(file);
                    }
                }

                return FileVisitResult.CONTINUE;
            }
        };

        Files.walkFileTree(path, visitor);

        return paths;
    }
}
