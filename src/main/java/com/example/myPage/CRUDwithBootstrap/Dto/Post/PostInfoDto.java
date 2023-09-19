package com.example.myPage.CRUDwithBootstrap.Dto.Post;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PostInfoDto {
    private final Long id;
    private final String title;
    private final String author;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;
}
