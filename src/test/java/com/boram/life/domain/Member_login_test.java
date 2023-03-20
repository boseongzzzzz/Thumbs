package com.boram.life.domain;

import com.boram.life.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
@Transactional
public class Member_login_test {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    public void setUp() {
        Member user1 = new Member(102910L, passwordEncoder.encode("pass01"));
        Member user2 = new Member(1029107L, passwordEncoder.encode("pass02"));

        memberRepository.save(user1);
        memberRepository.save(user2);
    }
    @Test
    public void findByUsernameTest() {
        Long memberId = 102910L;
        log.info("memberId : ", memberId);
        Optional<Member> memberId1 = memberRepository.findByMemberId(String.valueOf(memberId));
        log.info("memberId1 : ", memberId1);
        assertEquals(memberId, memberId1.get().getMemberId());
        assertTrue(passwordEncoder.matches("pass01", memberId1.get().getMemberPw()));
    }
}
