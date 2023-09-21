package com.example.myPage.CRUDwithBootstrap.Domain;

import com.example.myPage.CRUDwithBootstrap.Dto.Post.PostFormDto;
import com.example.myPage.CRUDwithBootstrap.Dto.Post.PostUpdateDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
public class Post extends BaseTimeEntity {

    @Builder
    public Post(Long id, String title, String content, Member author){
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    private String content;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Member author;

    public void postUpdate(PostFormDto postDto){
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
    }

}
