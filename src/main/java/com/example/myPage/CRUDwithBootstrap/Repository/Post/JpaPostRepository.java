package com.example.myPage.CRUDwithBootstrap.Repository.Post;

import com.example.myPage.CRUDwithBootstrap.Domain.Post;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaPostRepository implements PostRepository{

    private final EntityManager em;

    public Post savePost(Post post){
        em.persist(post);
        return post;
    }

    public Optional<Post> findById(Long id){
        return Optional.ofNullable(em.find(Post.class, id));
    }

    public List<Post> findByAuthorName(String name){
        return em.createQuery("select p from Post as p where p.author.name =: authorName", Post.class)
                .setParameter("authorName", name)
                .getResultList();
    }

    public List<Post> findByTitle(String title){
        return em.createQuery("select p from Post as p where p.title =: titleName", Post.class)
                .setParameter("titleName", title)
                .getResultList();
    }

    public List<Post> findAll(){
        return em.createQuery("select p from Post as p", Post.class)
                .getResultList();
    }
}
