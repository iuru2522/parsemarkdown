package com.parsemarkdown.controller;


import com.parsemarkdown.util.FileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    private final com.parsemarkdown.util.FileParser fileParser;

    @Autowired
    public FileController(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    @GetMapping("/parse-files")
    public String parseFiles() {
        fileParser.parseFiles();
        return "Files parsed successfully.";
    }
}
