package com.example.myPage.CRUDwithBootstrap.Dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class PostDto {
    private final String title;
    private final Date postDate;
    private final String content;
    private final String author;
}
