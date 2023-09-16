package com.example.myPage.CRUDwithBootstrap.Repository;

import com.example.myPage.CRUDwithBootstrap.Domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    @Override
    public Member addMember(Member member){
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(em.find(Member.class, id));
    }

    @Override
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member as m where m.name =: userName", Member.class)
                .setParameter("userName", name)
                .getResultList();
    }

    @Override
    public List<Member> findByNickname(String nickname) {
        return em.createQuery("select m from Member as m where m.nickname =: nickname", Member.class)
                .setParameter("nickname", nickname)
                .getResultList();
    }

    @Override
    public List<Member> findByEmail(String email) {
        return em.createQuery("select m from Member as m where m.email =: email", Member.class)
                .setParameter("email", email)
                .getResultList();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member as m", Member.class)
                .getResultList();
    }
}
