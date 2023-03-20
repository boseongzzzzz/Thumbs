package com.boram.life.member.service;

import com.boram.life.domain.Member;
import com.boram.life.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(userId).orElseThrow(() -> new UsernameNotFoundException("Member not found : " + userId));

        return new org.springframework.security.core.userdetails.User(
                String.valueOf(member.getMemberId()),
                member.getMemberPw(),
                Collections.singletonList(new SimpleGrantedAuthority(member.getAuthority().getAuthName()))
        );
    }

}
