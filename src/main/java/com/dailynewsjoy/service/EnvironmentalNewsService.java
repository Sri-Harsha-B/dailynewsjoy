package com.dailynewsjoy.service;


import com.dailynewsjoy.DTO.NewsDTO;
import com.dailynewsjoy.DTO.NewsRequestDTO;
import com.dailynewsjoy.entity.News;
import com.dailynewsjoy.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class EnvironmentalNewsService {

    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    private NewsRepository newsRepository;
    private String apiUrl = "http://eventregistry.org/api/v1/article/getArticlesForTopicPage";


    public EnvironmentalNewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String callRestApi() {

        NewsRequestDTO requestBody = new NewsRequestDTO();
        requestBody.setUri("240f6a12-b9d8-40a6-b1c6-a220e31d08de");
        requestBody.setInfoArticleBodyLen(-1);
        requestBody.setResultType("articles");
        requestBody.setArticlesSortBy("fq");
        requestBody.setApiKey("45010b75-1915-4106-b97f-f5a2368251a1");

        HttpEntity<NewsRequestDTO> requestEntity = new HttpEntity<>(requestBody);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, String.class);
        /*ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
         */
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // Handle the error or throw an exception
            return "Error: " + responseEntity.getStatusCode();
        }
    }


    public int saveNews(final NewsDTO newsDTO) {
        News news = convertNewsDTOTOEntity(newsDTO);
        News savedNews = newsRepository.save(news);
        if (savedNews != null) {
            return 200;
        }
        return 0;

    }


    private News convertNewsDTOTOEntity(final NewsDTO newsDTO) {
        News news = new News();
        Date now = new Date();
        news.setDateTime(now);
        news.setBody(newsDTO.getBody());
        news.setTitle(newsDTO.getTitle());
        news.setImage(newsDTO.getImage());
        return news;
    }
}
