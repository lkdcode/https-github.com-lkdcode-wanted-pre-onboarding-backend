package com.example.wantedbackend.post.domain;

import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.support.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor/*(access = AccessLevel.PROTECTED)*/
@Entity
@Builder
public class Post extends BaseEntity {

    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Member member;


    public void updateTitle(String updateTitle) {
        this.title = updateTitle;
    }

    public void updateContent(String updateContent) {
        this.content = updateContent;
    }
}
