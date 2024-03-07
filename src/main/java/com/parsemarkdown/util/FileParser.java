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

    @Value("${file.parser.source.directory}")
    private String sourceDirectoryPath;

    public void parseFiles() {

        try {
            parseFiles(Paths.get(sourceDirectoryPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseFiles(Path sourceDirectory) throws IOException {

        if (!Files.exists(sourceDirectory) || !Files.isDirectory(sourceDirectory)) {
            System.out.println("Source directory does not exist or is not a directory.");
            return;
        }

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDirectory)) {
            for (Path filePath : directoryStream) {

                if (Files.isRegularFile(filePath)) {

                    parseFile(filePath);
                }
            }
        }
    }

    private void parseFile(Path filePath) throws IOException {

        String fileContent = Files.readString(filePath);

        System.out.println("File: " + filePath.getFileName());
        System.out.println("Content:");
        System.out.println(fileContent);
        System.out.println("-----------------------------");
    }
}
