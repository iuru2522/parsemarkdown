package com.parsemarkdown.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.parsemarkdown.util.FileParser;

@Controller
public class HomeController {

    @Autowired
    private FileParser fileParser;

    @GetMapping("/")
    public String home(@ModelAttribute("filename") String filename, Model model) {
        if (filename == null || filename.isEmpty()) {
            filename = "test.md"; // Default filename
        }

        try {
            String markdownContent = fileParser.readMarkdownFile(filename);
            model.addAttribute("markdownContent", markdownContent);
        } catch (IOException e) {
            model.addAttribute("error", "Error reading Markdown file: " + filename);
            return "error";
        }

        return "home";
    }
}