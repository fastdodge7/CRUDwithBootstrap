package com.example.myPage.CRUDwithBootstrap.Dto.Post;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class PostFormDto {
    private final String title;
    private final String content;
    private final String author;
}
