package com.example.myPage.CRUDwithBootstrap.Service;

import com.example.myPage.CRUDwithBootstrap.Domain.Post;
import com.example.myPage.CRUDwithBootstrap.Repository.Post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Transactional
    public Post postSave(Post post){
        postRepository.savePost(post);
        return post;
    }

    @Transactional
    public List<Post> listAllPost(){
        return postRepository.findAll();
    }

    @Transactional
    public Optional<Post> findById(Long id){
        return postRepository.findById(id);
    }

    @Transactional
    public List<Post> findByAuthor(String name){
        return postRepository.findByAuthorName(name);
    }
}
