package com.example.myPage.CRUDwithBootstrap.Service;

import com.example.myPage.CRUDwithBootstrap.Domain.Member;
import com.example.myPage.CRUDwithBootstrap.Repository.Member.MemberRepository;
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

    @Transactional
    public List<Member> listAllMember(){
        return memberRepository.findAll();
    }

    @Transactional
    public Optional<Member> findById(Long id){
        return memberRepository.findById(id);
    }

    @Transactional
    public List<Member> findByName(String name){
        return memberRepository.findByName(name);
    }

    @Transactional
    public List<Member> findByNickname(String nickname){
        return memberRepository.findByNickname(nickname);
    }
}
