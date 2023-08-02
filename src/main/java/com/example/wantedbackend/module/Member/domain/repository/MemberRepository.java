package com.example.wantedbackend.module.Member.domain.repository;

import com.example.wantedbackend.module.Member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
