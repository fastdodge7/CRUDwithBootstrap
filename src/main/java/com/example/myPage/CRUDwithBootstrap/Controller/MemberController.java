package com.example.myPage.CRUDwithBootstrap.Controller;

import com.example.myPage.CRUDwithBootstrap.Domain.Member;
import com.example.myPage.CRUDwithBootstrap.Dto.MemberFormDto;
import com.example.myPage.CRUDwithBootstrap.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){ this.memberService = memberService; }

    @GetMapping("member/new")
    public String member(Model model){

        return "memberRegistration";
    }

    @GetMapping("member/list")
    public String memberList(Model model){
        List<Member> memberList = memberService.listAllMember();
        model.addAttribute("memberList", memberList);
        return "memberList";
    }


    @PostMapping(value = {"member/new"})
    public String memberRegistration(Model model, MemberFormDto form){
        System.out.println(form.getName());

        Member newMember = Member.builder()
                .name(form.getName())
                .nickname(form.getNickname())
                .email(form.getEmail()).build();

        memberService.registNewMember(newMember);
        return "redirect:/member/new";
    }
}
