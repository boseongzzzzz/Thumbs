package com.boram.life.member.repository;

import com.boram.life.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void save(Member member);

    Optional<Member> findByMemberId(String username);

    List<Member> findAll();
}