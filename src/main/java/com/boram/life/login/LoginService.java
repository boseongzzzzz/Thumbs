package com.boram.life.login;

import com.boram.life.domain.Member;
import com.boram.life.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    private PasswordEncoder passwordEncoder;

    public boolean loginProcessing(Long memberId, String memberPw){
        Member member = memberRepository.findByMemberId(memberId.toString()).get();
        System.out.println(member.getMemberPw() + " : " + member.getMemberId());
        return passwordEncoder.matches(memberPw, member.getMemberPw());
    }
}
