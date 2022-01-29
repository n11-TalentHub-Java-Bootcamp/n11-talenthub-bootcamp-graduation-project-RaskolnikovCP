package com.ozansaribal.n11bootcamp.graduation_project.Converter;

import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberDto;
import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberSaveRequestDto;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    List<MemberDto> convertMemberListToMemberDtoList(List<Member> memberList);

    MemberDto convertMemberToMemberDto(Member member);

    Member convertMemberDtoToMember(MemberDto memberDto);

    Member convertMemberSaveRequestDtoToMember(MemberSaveRequestDto memberSaveRequestDto);

}
