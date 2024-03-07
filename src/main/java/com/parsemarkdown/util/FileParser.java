// package com.parsemarkdown.util;


// import org.springframework.stereotype.Component;
// import java.io.IOException;
// import java.nio.file.DirectoryStream;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;

// @Component
// public class FileParser {
//     // Define the source directory (you can change this to be configurable)
//     private String sourceDirectoryPath = "/Users/midwest/Downloads/parsemarkdown/src/main/resources/static";

//     public void parseFiles() {
//         // Parse files in the source directory
//         try {
//             parseFiles(Paths.get(sourceDirectoryPath));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private void parseFiles(Path sourceDirectory) throws IOException {
//         // Check if the source directory exists
//         if (!Files.exists(sourceDirectory) || !Files.isDirectory(sourceDirectory)) {
//             System.out.println("Source directory does not exist or is not a directory.");
//             return;
//         }

//         // Iterate through the files in the source directory
//         try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDirectory)) {
//             for (Path filePath : directoryStream) {
//                 // Check if the file is a regular file (not a directory)
//                 if (Files.isRegularFile(filePath)) {
//                     // Parse the file (you can implement your parsing logic here)
//                     parseFile(filePath);
//                 }
//             }
//         }
//     }

//     private void parseFile(Path filePath) throws IOException {
//         // Read the contents of the file
//         String fileContent = Files.readString(filePath);

//         // Print the file content (you can replace this with your parsing logic)
//         System.out.println("File: " + filePath.getFileName());
//         System.out.println("Content:");
//         System.out.println(fileContent);
//         System.out.println("-----------------------------");
//     }
// }





package com.parsemarkdown.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileParser {
    // Define the source directory as a configurable property
    @Value("${file.parser.source.directory}")
    private String sourceDirectoryPath;

    public void parseFiles() {
        // Parse files in the source directory
        try {
            parseFiles(Paths.get(sourceDirectoryPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseFiles(Path sourceDirectory) throws IOException {
        // Check if the source directory exists
        if (!Files.exists(sourceDirectory) || !Files.isDirectory(sourceDirectory)) {
            System.out.println("Source directory does not exist or is not a directory.");
            return;
        }

        // Iterate through the files in the source directory
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDirectory)) {
            for (Path filePath : directoryStream) {
                // Check if the file is a regular file (not a directory)
                if (Files.isRegularFile(filePath)) {
                    // Parse the file (you can implement your parsing logic here)
                    parseFile(filePath);
                }
            }
        }
    }

    private void parseFile(Path filePath) throws IOException {
        // Read the contents of the file
        String fileContent = Files.readString(filePath);

        // Print the file content (you can replace this with your parsing logic)
        System.out.println("File: " + filePath.getFileName());
        System.out.println("Content:");
        System.out.println(fileContent);
        System.out.println("-----------------------------");
    }
}
