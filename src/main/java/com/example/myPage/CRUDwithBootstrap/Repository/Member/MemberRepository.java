package com.example.myPage.CRUDwithBootstrap.Repository.Member;

import com.example.myPage.CRUDwithBootstrap.Domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    public Member addMember(Member member);

    public Optional<Member> findById(Long id);

    public List<Member> findByName(String name);

    public List<Member> findByNickname(String nickname);

    public List<Member> findByEmail(String email);

    public List<Member> findAll();
}
