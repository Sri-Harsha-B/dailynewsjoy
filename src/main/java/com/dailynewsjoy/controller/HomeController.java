package com.dailynewsjoy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping(value = "/getNews")
    public String getNews() {
        return "Here are the latest news!!";
    }
}
