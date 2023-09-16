package com.example.myPage.CRUDwithBootstrap.RepositoryTest.MemberRepositoryTest;

import com.example.myPage.CRUDwithBootstrap.Domain.Member;
import com.example.myPage.CRUDwithBootstrap.Repository.JpaMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
public class JpaMemberRepositoryTest {

    @Autowired
    JpaMemberRepository memberRepository;

    @Test
    public void 멤버등록_테스트() throws Exception {
        Member newMember = Member.builder()
                .name("tester1")
                .nickname("testnick1")
                .email("testemail1").build();

        memberRepository.addMember(newMember);

        Member foundMember = memberRepository.findById(newMember.getId()).get();
        assertEquals(newMember.getId(), foundMember.getId());
        assertEquals(newMember.getName(), foundMember.getName());
        assertEquals(newMember.getNickname(), foundMember.getNickname());
        assertEquals(newMember.getEmail(), foundMember.getEmail());
    }

}
