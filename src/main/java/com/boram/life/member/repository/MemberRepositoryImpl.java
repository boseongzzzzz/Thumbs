package com.boram.life.member.repository;

import com.boram.life.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MemberRepositoryImpl implements MemberRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Optional<Member> findByMemberId(String username) {
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.memberId = :memberId", Member.class);
        query.setParameter("memberId", Long.parseLong(username));
        List<Member> result = query.getResultList();

        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    @Override
    public List<Member> findAll() {
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
        return query.getResultList();
    }
}
