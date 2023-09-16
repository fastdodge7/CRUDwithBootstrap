package com.example.myPage.CRUDwithBootstrap.Domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Date postDate;

    @Lob
    private String content;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Member author;

}
