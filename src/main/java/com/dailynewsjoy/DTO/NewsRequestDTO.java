package com.dailynewsjoy.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsRequestDTO {

    private String uri;
    private int infoArticleBodyLen;
    private String resultType;
    private String articlesSortBy;
    private String apiKey;
}
