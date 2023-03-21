package com.boram.life.login;

import com.boram.life.domain.Member;
import com.boram.life.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    EntityManager em;

    public boolean loginProcessing(Long memberId, String memberPw){

        Member member = memberRepository.findByMemberId(memberId.toString()).get();

        System.out.println("member.getMemberPw() : " + member.getMemberPw());

        return bCryptPasswordEncoder.matches(memberPw, member.getMemberPw());

    }
}
