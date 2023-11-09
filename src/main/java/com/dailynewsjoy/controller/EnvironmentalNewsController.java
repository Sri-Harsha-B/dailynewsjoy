package com.dailynewsjoy.controller;

import com.dailynewsjoy.service.EnvironmentalNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EnvironmentalNewsController {


    @Autowired
    private EnvironmentalNewsService environmentalNewsService;


    @GetMapping(value = "/getAPINews")
    public ResponseEntity<String> getNews() {
        String response = environmentalNewsService.callRestApi();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
