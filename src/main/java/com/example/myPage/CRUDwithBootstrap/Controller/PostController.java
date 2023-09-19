package com.example.myPage.CRUDwithBootstrap.Controller;

import com.example.myPage.CRUDwithBootstrap.Domain.Member;
import com.example.myPage.CRUDwithBootstrap.Domain.Post;
import com.example.myPage.CRUDwithBootstrap.Dto.Post.PostFormDto;
import com.example.myPage.CRUDwithBootstrap.Dto.Post.PostInfoDto;
import com.example.myPage.CRUDwithBootstrap.Service.MemberService;
import com.example.myPage.CRUDwithBootstrap.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    MemberService memberService;
    PostService postService;
    @Autowired
    public PostController(MemberService memberService, PostService postService){
        this.memberService = memberService;
        this.postService = postService;
    }


    @GetMapping("post")
    public String post(Model model){
        return "post";
    }

    @PostMapping("post")
    public String postArticle(Model model, PostFormDto postDto){
        System.out.println("title : " + postDto.getTitle() + "\nauthor : " + postDto.getAuthor() + "\ncontent : " + postDto.getContent());

        try{
            List<Member> author = memberService.findByName(postDto.getAuthor());
            if(author.isEmpty()) throw new IllegalStateException("등록된 사용자 이름이 아닙니다.");

            Post newPost = Post.builder()
                    .title(postDto.getTitle())
                    .author(author.get(0))
                    .content(postDto.getContent()).build();

            postService.postSave(newPost);
        }catch(IllegalStateException e){

        }finally {
            return "redirect:/member/post";
        }
    }

    @GetMapping("post/list")
    public String listAllPost(Model model){
        List<Post> postList = postService.listAllPost();

        model.addAttribute("postList",postList.stream().map( element -> {
            return new PostInfoDto(element.getId(), element.getTitle(), element.getAuthor().getName(), element.getCreatedDate(), element.getModifiedDate());
        }));
        return "postList";
    }

    @GetMapping("post/view/{id}")
    public String getPost(Model model, @PathVariable Long id){
        model.addAttribute("post", postService.findById(id).get());
        return "postView";
    }
}
