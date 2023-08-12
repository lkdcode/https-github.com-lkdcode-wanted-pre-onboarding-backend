package com.example.wantedbackend.member.domain;

import com.example.wantedbackend.member.domain.type.MemberStatus;
import com.example.wantedbackend.support.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "fly_member")
@Entity(name = "flyMember")
public class Member extends BaseEntity {

    private String email;
    private String password;

    // 생명 주기를 관리하는 컬럼
    @Enumerated(EnumType.STRING)
    private MemberStatus status = MemberStatus.CREATED;

}
