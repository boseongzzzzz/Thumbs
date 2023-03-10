package com.boram.life.domain;

import com.boram.life.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Rollback(value = false)
@Slf4j
@Transactional
@RequiredArgsConstructor
class MemberTest {

    MemberRepository memberRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    public void 맴버_도메인_테스트(){
        //given
        Member member1 = new Member();
        member1.setMemberPw("1234");
        member1.setMemberAddress("서울특별시 강남구");
        member1.setMemberGender("여성");
        member1.setMemberRegNo("950101-1234567");
        member1.setMemberEmail("member1@example.com");
        member1.setMemberName("김철수");
        member1.setMemberIntroduction("안녕하세요. 처음 뵙겠습니다.");

        //when
        memberRepository.saveMember(member1);

        Member member = em.find(Member.class, member1.getMemberId());

        //then

//        assertEquals(member1, member);
    }
}