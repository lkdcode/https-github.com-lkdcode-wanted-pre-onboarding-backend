package com.example.wantedbackend.module.Member.domain;

import com.example.wantedbackend.global.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name ="tb_mebmer")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
}
