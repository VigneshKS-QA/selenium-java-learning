package Intro;

import java.io.File;
import java.util.Arrays;

public class FileSorter {
    public static void main(String[] args) {
        File folder = new File("src/Intro"); // This path is relative to the project root

        File[] files = folder.listFiles();
        if (files == null) {
            System.out.println("Folder not found or empty.");
            return;
        }

        Arrays.sort(files, (f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));

        for (File file : files) {
            System.out.printf("%-25s Last Modified: %tc%n", file.getName(), file.lastModified());
        }
    }
}
