package co2103.hw1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    // Handles GET requests for the root ("/") URL, displaying the start page.
    @GetMapping("/")
    public String showStartPage() {
        return "start";
    }

    // Handles POST requests for the root ("/") URL, returning the start page.
    @PostMapping("/")
    public String handlePostRequest() {
        return "start";
    }
}

