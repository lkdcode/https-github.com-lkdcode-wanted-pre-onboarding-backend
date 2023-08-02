package com.example.wantedbackend.global.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
//@EntityListeners
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDt;
    @LastModifiedDate
    private LocalDateTime modifyDt;

}