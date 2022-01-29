package com.ozansaribal.n11bootcamp.graduation_project.Service;

import com.ozansaribal.n11bootcamp.graduation_project.Converter.MemberMapper;
import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberDto;
import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberSaveRequestDto;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberDataProvider {

    public static Member convertMemberDtoToMember(MemberDto memberDto) {

        Member member = MemberMapper.INSTANCE
                .convertMemberDtoToMember(memberDto);
        return member;

    }

    public static List<MemberDto> convertMemberListToMemberDtoList(List<Member> memberList) {

        List<MemberDto> memberDtoList = MemberMapper.INSTANCE
                .convertMemberListToMemberDtoList(memberList);
        return memberDtoList;

    }

    public static Member convertMemberSaveRequestDtoToMember(MemberSaveRequestDto memberSaveRequestDto) {

        Member member = MemberMapper.INSTANCE
                .convertMemberSaveRequestDtoToMember(memberSaveRequestDto);
        return member;

    }

    public static Member getMember(){

        Member member1 = new Member();
        member1.setId(1L);
        member1.setPersonalNumber("19938820055");
        member1.setFirstName("first_name_1");
        member1.setLastName("last_name_1");
        member1.setMonthlyIncome(3500.0);
        member1.setTelephoneNumber("05346667788");
        member1.setBirthDate(LocalDate.parse("1994-04-21"));
        member1.setDepositAmount(4500.0);
        member1.setCreditScore(((3500.0*8)/100.0));

        return member1;

    }

    public static MemberSaveRequestDto getMemberSaveRequestDto(Long id){

        MemberSaveRequestDto memberSaveRequestDto1 = new MemberSaveRequestDto();
        memberSaveRequestDto1.setPersonalNumber("19938820055");
        memberSaveRequestDto1.setFirstName("first_name_1");
        memberSaveRequestDto1.setLastName("last_name_1");
        memberSaveRequestDto1.setMonthlyIncome(3500.0);
        memberSaveRequestDto1.setTelephoneNumber("05346667788");
        memberSaveRequestDto1.setBirthDate(LocalDate.parse("1994-04-21"));
        memberSaveRequestDto1.setDepositAmount(4500.0);

        return memberSaveRequestDto1;

    }

    public static MemberDto getMemberDto(Long id){

        MemberDto memberDto1 = new MemberDto();
        memberDto1.setId(id);
        memberDto1.setPersonalNumber("19938820055");
        memberDto1.setFirstName("first_name_1");
        memberDto1.setLastName("last_name_1");
        memberDto1.setMonthlyIncome(3500.0);
        memberDto1.setTelephoneNumber("05346667788");
        memberDto1.setBirthDate(LocalDate.parse("1994-04-21"));
        memberDto1.setDepositAmount(4500.0);
        memberDto1.setCreditScore(((3500.0*8)/100.0));

        return memberDto1;

    }

    public static MemberDto getMemberDtoByPersonalNumber(String personalNumber){

        MemberDto memberDto1 = new MemberDto();
        memberDto1.setId(1L);
        memberDto1.setPersonalNumber(personalNumber); //"19938820055"
        memberDto1.setFirstName("first_name_1");
        memberDto1.setLastName("last_name_1");
        memberDto1.setMonthlyIncome(3500.0);
        memberDto1.setTelephoneNumber("05346667788");
        memberDto1.setBirthDate(LocalDate.parse("1994-04-21"));
        memberDto1.setDepositAmount(4500.0);
        memberDto1.setCreditScore(((3500.0*8)/100.0));

        return memberDto1;

    }

    public static List<Member> getAllMemberList(){

        List<Member> memberList = new ArrayList<>();

        Member member1 = new Member();
        member1.setId(1L);
        member1.setPersonalNumber("19938820055");
        member1.setFirstName("first_name_1");
        member1.setLastName("last_name_1");
        member1.setMonthlyIncome(3500.0);
        member1.setTelephoneNumber("05346667788");
        member1.setBirthDate(LocalDate.parse("1994-04-21"));
        member1.setDepositAmount(4500.0);
        member1.setCreditScore(((3500.0*8)/100.0));
        memberList.add(member1);

        Member member2 = new Member();
        member2.setId(2L);
        member2.setPersonalNumber("29486710988");
        member2.setFirstName("first_name_2");
        member2.setLastName("last_name_2");
        member2.setMonthlyIncome(5000.0);
        member2.setTelephoneNumber("05336578979");
        member2.setBirthDate(LocalDate.parse("1987-09-19"));
        member2.setDepositAmount(2700.0);
        member2.setCreditScore(((5000.0*8)/100.0));
        memberList.add(member2);


        Member member3 = new Member();
        member3.setId(3L);
        member3.setPersonalNumber("28848891292");
        member3.setFirstName("first_name_3");
        member3.setLastName("last_name_3");
        member3.setMonthlyIncome(12000.0);
        member3.setTelephoneNumber("05346947690");
        member3.setBirthDate(LocalDate.parse("1982-02-22"));
        member3.setDepositAmount(12000.0);
        member3.setCreditScore(((12000.0*8)/100.0));
        memberList.add(member3);


        Member member4 = new Member();
        member4.setId(4L);
        member4.setPersonalNumber("34556723456");
        member4.setFirstName("first_name_4");
        member4.setLastName("last_name_4");
        member4.setMonthlyIncome(10000.0);
        member4.setTelephoneNumber("05456785949");
        member4.setBirthDate(LocalDate.parse("1978-05-15"));
        member4.setDepositAmount(8000.0);
        member4.setCreditScore(((10000.0*8)/100.0));
        memberList.add(member4);


        Member member5 = new Member();
        member5.setId(5L);
        member5.setPersonalNumber("36699923457");
        member5.setFirstName("first_name_5");
        member5.setLastName("last_name_5");
        member5.setMonthlyIncome(35000.0);
        member5.setTelephoneNumber("05229558456");
        member5.setBirthDate(LocalDate.parse("1975-11-05"));
        member5.setDepositAmount(16000.0);
        member5.setCreditScore(((35000.0*8)/100.0));
        memberList.add(member5);

        return memberList;

    }


}
