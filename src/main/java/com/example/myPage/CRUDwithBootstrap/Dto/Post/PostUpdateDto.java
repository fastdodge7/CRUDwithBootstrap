package com.example.myPage.CRUDwithBootstrap.Dto.Post;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PostUpdateDto {
    private final String newTitle;
    private final String newContent;
}
