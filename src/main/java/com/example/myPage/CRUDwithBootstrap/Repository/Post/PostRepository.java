package com.example.myPage.CRUDwithBootstrap.Repository.Post;

import com.example.myPage.CRUDwithBootstrap.Domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    public Post savePost(Post post);
    public Optional<Post> findById(Long id);

    public List<Post> findByAuthorName(String name);

    public List<Post> findByTitle(String title);

    public List<Post> findAll();
}
