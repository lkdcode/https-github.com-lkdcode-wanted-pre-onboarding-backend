package com.example.wantedbackend.member.domain;

import com.example.wantedbackend.member.domain.type.MemberStatus;
import com.example.wantedbackend.support.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseEntity {

    private String name;
    private String email;
    private String password;

    // 생명 주기를 관리하는 컬럼
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

}
