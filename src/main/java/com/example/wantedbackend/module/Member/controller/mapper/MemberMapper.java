package com.example.wantedbackend.module.Member.controller.mapper;

import com.example.wantedbackend.module.Member.controller.dto.request.SigninRequestDTO;
import com.example.wantedbackend.module.Member.controller.dto.request.SignupRequestDTO;
import com.example.wantedbackend.module.Member.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(target = "account", source = "account")
    Member toEntity(SignupRequestDTO dto);

    @Mapping(target = "account", source = "account")
    Member toEntity(SigninRequestDTO dto);
}
