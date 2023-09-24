package com.example.myPage.CRUDwithBootstrap.Controller;

import com.example.myPage.CRUDwithBootstrap.Domain.Member;
import com.example.myPage.CRUDwithBootstrap.Domain.Post;
import com.example.myPage.CRUDwithBootstrap.Dto.Post.PostFormDto;
import com.example.myPage.CRUDwithBootstrap.Dto.Post.PostUpdateDto;
import com.example.myPage.CRUDwithBootstrap.Service.MemberService;
import com.example.myPage.CRUDwithBootstrap.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
            System.out.println(e.getMessage());
        }finally {
            return "redirect:/post";
        }
    }

    @GetMapping("post/list")
    public String listAllPost(Model model){
        List<Post> postList = postService.listAllPost();

        model.addAttribute("postList", postList);
        return "postList";
    }

    @GetMapping("post/view/{id}")
    public String getPost(Model model, @PathVariable Long id){
        model.addAttribute("post", postService.findById(id).orElseThrow(() -> new IllegalStateException("postId not found")));
        return "postView";
    }

    @GetMapping("post/update/{id}")
    public String updatePost(Model model, @PathVariable Long id){
        model.addAttribute("post", postService.findById(id).orElseThrow(() -> new IllegalStateException("postId not found")));
        return "postUpdate";
    }

    @PostMapping("post/update/{id}")
    public String updatePost(Model model, @PathVariable Long id, PostFormDto postUpdateDto){
        Post target = postService.findById(id).orElseThrow(() -> new IllegalStateException("postId not found"));
        postService.postUpdate(target.getId(), postUpdateDto);
        return "redirect:/post/list";

    }

    @GetMapping("post/delete/{id}")
    public String deletePost(Model model, @PathVariable Long id){
        Post target = postService.findById(id).orElseThrow(() -> new IllegalStateException("postId not found"));
        postService.postDelete(target.getId());
        return "redirect:/post/list";
    }
}
