package com.example.myPage.CRUDwithBootstrap.Service;

import com.example.myPage.CRUDwithBootstrap.Domain.Member;
import com.example.myPage.CRUDwithBootstrap.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository mr){
        this.memberRepository = mr;
    }

    @Transactional
    public Member registNewMember(Member member){
        memberRepository.addMember(member);
        return member;
    }

    public List<Member> listAllMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findById(Long id){
        return memberRepository.findById(id);
    }
}
