package dev.stemvault.scanner;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class FileScanner {

    private ArrayList<String> extensions;

    public FileScanner(ArrayList<String> extensions) {
        this.extensions = extensions;
    }

    private ArrayList<Path> paths = new ArrayList<>();

    public ArrayList<Path> scan(Path path) throws IOException {
        SimpleFileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(
                Path file,
                BasicFileAttributes attrs
            ) throws IOException {
                for (String extension : extensions) {
                    String tmp = file.getFileName().toString();
                    tmp = tmp.toLowerCase();
                    if (tmp.endsWith(extension)) {
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
