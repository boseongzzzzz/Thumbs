package com.boram.life.domain;

import com.boram.life.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class Member_login_test {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    public void setUp() {
        Member user1 = new Member(1234L, passwordEncoder.encode("pass01"));

        memberRepository.save(user1);
    }
    @Test
    public void findByUsernameTest() {
        Long memberId = 1234L;
        log.info("memberId : ", memberId);
        Optional<Member> memberId1 = memberRepository.findByMemberId(String.valueOf(memberId));
        assertEquals(memberId, memberId1.get().getMemberId());
        assertTrue(passwordEncoder.matches("pass01", memberId1.get().getMemberPw()));
    }
}
