package com.dailynewsjoy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Table(name = "news")
@Entity
@Getter
@Setter
public class News {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true)
    private int id;
    @Column(name = "date_time")
    private Date dateTime;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "body")
    private String body;
}
