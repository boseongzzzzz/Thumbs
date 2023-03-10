package com.boram.life.member.repository;

import com.boram.life.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;


    public void saveMember(Member member){
        em.persist(member);
    }

    public Member findMember(Long memberId){
       return em.find(Member.class, memberId);
    }
}
