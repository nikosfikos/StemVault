package dev.stemvault;

import dev.stemvault.scanner.FileScanner;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> extensions = new ArrayList<String>();
        extensions.add(".java");

        FileScanner scanner = new FileScanner(extensions);

        try {
            ArrayList<Path> paths = scanner.scan(Path.of("."));
            for (Path path : paths) {
                System.out.println(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
