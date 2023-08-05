package com.example.wantedbackend.module.Member.domain;

import com.example.wantedbackend.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "tb_member")
@ToString
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_idx", nullable = false)
    private Long idx;

    @Column(name = "member_account", nullable = false)
    private String account;

    @Column(name = "member_password", nullable = false)
    private String password;

}
