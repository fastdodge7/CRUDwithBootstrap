package com.example.myPage.CRUDwithBootstrap.RepositoryTest;

import com.example.myPage.CRUDwithBootstrap.Domain.Member;
import com.example.myPage.CRUDwithBootstrap.Domain.Post;
import com.example.myPage.CRUDwithBootstrap.Dto.Post.PostFormDto;
import com.example.myPage.CRUDwithBootstrap.Repository.Member.JpaMemberRepository;
import com.example.myPage.CRUDwithBootstrap.Repository.Post.JpaPostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
public class PostRepositoryTest {

    @Autowired
    JpaMemberRepository memberRepository;

    @Autowired
    JpaPostRepository postRepository;

    @Test
    public void 멤버등록_테스트() throws Exception {
        Member newMember = Member.builder()
                .name("modTester")
                .nickname("modTester")
                .email("modTester").build();

        memberRepository.addMember(newMember);

        Member foundMember = memberRepository.findById(newMember.getId()).get();
        assertEquals(newMember.getId(), foundMember.getId());
        assertEquals(newMember.getName(), foundMember.getName());
        assertEquals(newMember.getNickname(), foundMember.getNickname());
        assertEquals(newMember.getEmail(), foundMember.getEmail());

        Post newPost = Post.builder()
                .title("initTitle")
                .author(newMember)
                .content("initContent")
                .build();

        postRepository.savePost(newPost);
        assertEquals(newPost.getTitle(), "initTitle");
        assertEquals(newPost.getContent(), "initContent");

        PostFormDto dto = new PostFormDto("modified Title", "Modified Contents", newMember.getName());
        newPost.postUpdate(dto);


        Post target = postRepository.findById(newPost.getId()).orElseThrow(() -> new IllegalStateException("테스트 실패"));

        assertEquals(target.getTitle(), "modified Title");
        assertEquals(target.getContent(), "Modified Contents");

    }

}
