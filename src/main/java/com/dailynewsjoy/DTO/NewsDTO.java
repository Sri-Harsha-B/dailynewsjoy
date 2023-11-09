package com.dailynewsjoy.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class NewsDTO {

    private int id;
    private Date dateTime;
    private String title;
    private String image;
    private String body;
}
