package asu.utils;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static void createFile(String path, String filename, String extension) throws IOException {
        String fileNameWithExtension = String.format("%s%s.%s", path, filename, extension);
        System.out.println(fileNameWithExtension);
        File myObj = new File(fileNameWithExtension);
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }

    }
}
