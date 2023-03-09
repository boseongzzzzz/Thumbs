package com.boram.life.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@Rollback
@DataJpaTest
@Transactional
class MemberTest {

    @PersistenceContext
    EntityManager em;
    @Test
    public void 맴버_도메인_테스트(){
        //given
        Member member1 = new Member();
        member1.setPw("1234");
        member1.setAddress("서울특별시 강남구");
        member1.setGender("여성");
        member1.setRegNo("950101-1234567");
        member1.setEmail("member1@example.com");
        member1.setName("김철수");
        member1.setIntroduction("안녕하세요. 처음 뵙겠습니다.");

        //when
        em.persist(member1);
        Member member = em.find(Member.class, member1.getMemberId());

        //then

//        assertEquals(member1, member);
    }
}