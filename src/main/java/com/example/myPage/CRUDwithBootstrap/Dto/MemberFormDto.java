package com.example.myPage.CRUDwithBootstrap.Dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberFormDto {
    private final String name;
    private final String nickname;
    private final String email;
}
