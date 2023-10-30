package ru.kata.spring.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping()
    public String startPage() {
        return "start-page";
    }
}
