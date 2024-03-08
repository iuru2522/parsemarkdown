package com.parsemarkdown.controller;

import com.parsemarkdown.util.FileParser;

import java.io.IOException;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FileController {

    @Autowired
    private FileParser fileParser;

    @GetMapping("/parse-files")
    public String parseFiles() {
        fileParser.parseFiles();
        return "Files parsed successfully.";
    }

    // @GetMapping("/render-markdown")
    // public String renderMarkdown(@RequestParam String filename) throws IOException {
    //     String markdownContent = readMarkdownFile(filename);


    //     Parser parser = Parser.builder().build();
    //     Node document = parser.parse(markdownContent);


    //     HtmlRenderer renderer = HtmlRenderer.builder().build();
    //     String htmlContent = renderer.render(document);

    //     return htmlContent;
    // }


    @GetMapping("/render-markdown")
    public String renderMarkdown() throws IOException {
        String filename = "test.md"; // Or your preferred logic for default filename
        String markdownContent = readMarkdownFile(filename);

        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdownContent);

        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String htmlContent = renderer.render(document);

        return htmlContent;
    }


    private String readMarkdownFile(String filename) throws IOException {
    try {
        return fileParser.readMarkdownFile(filename);
    } catch (IOException e) {
        // Handle the exception appropriately
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error reading Markdown file: " + filename, e);
    }
}
}
