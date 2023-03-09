package com.boram.life.member.repository;

import com.boram.life.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class memberRepository {

    @PersistenceContext
    EntityManager em;

    public void saveMember(Member member){
        em.persist(member);
    }

    public Member findMember(Long memberId){
       return em.find(Member.class, memberId);
    }
}
