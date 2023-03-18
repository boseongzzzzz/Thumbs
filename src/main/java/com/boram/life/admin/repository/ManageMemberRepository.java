package com.boram.life.admin.repository;

import com.boram.life.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManageMemberRepository extends JpaRepository<Member, Integer> {
}
