package ru.lubovflek.daysto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DaysToController {

    @GetMapping
    public String welcomePage() {
        return "Welcome to the app \"DaysTo\"!";
    }
}
