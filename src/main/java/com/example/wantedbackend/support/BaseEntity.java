package com.example.wantedbackend.support;


import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@Getter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt = Instant.now();

    @UpdateTimestamp
    private Instant updatedAt;

}
