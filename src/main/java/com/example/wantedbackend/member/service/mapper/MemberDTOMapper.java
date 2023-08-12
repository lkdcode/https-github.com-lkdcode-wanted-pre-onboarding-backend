package com.example.wantedbackend.member.service.mapper;

import com.example.wantedbackend.member.domain.Member;
import com.example.wantedbackend.member.domain.type.MemberStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberDTOMapper {

    //    @Mapping(target = "password", source = "password")
    Member from(
            String email
            , String password
            , String name
            , MemberStatus status
    );

}
