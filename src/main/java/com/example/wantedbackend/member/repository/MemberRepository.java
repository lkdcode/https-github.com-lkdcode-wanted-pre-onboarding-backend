package com.example.wantedbackend.member.repository;

import com.example.wantedbackend.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsMemberByEmail(String email);

}
