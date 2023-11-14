package com.dailynewsjoy.controller;

import com.dailynewsjoy.DTO.NewsDTO;
import com.dailynewsjoy.service.EnvironmentalNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "/saveNews")
    public ResponseEntity<Integer> saveNews(@RequestBody NewsDTO newsDTO) {
        int reponse = environmentalNewsService.saveNews(newsDTO);
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(value = "/getDBNews")
    public ResponseEntity<List<NewsDTO>> getDBNews() {
        List<NewsDTO> response = environmentalNewsService.fetchNewsFromDatabase();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
