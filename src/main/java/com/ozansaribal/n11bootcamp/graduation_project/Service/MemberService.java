package com.ozansaribal.n11bootcamp.graduation_project.Service;

import com.ozansaribal.n11bootcamp.graduation_project.Converter.MemberMapper;
import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberDto;
import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberSaveRequestDto;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;
import com.ozansaribal.n11bootcamp.graduation_project.Service.EntityService.MemberEntityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class MemberService {

    private MemberEntityService memberEntityService;

    public MemberDto save(MemberSaveRequestDto memberSaveRequestDto) {

        Member member = MemberMapper.INSTANCE.convertMemberSaveRequestDtoToMember(memberSaveRequestDto);

        member = memberEntityService.save(member);

        MemberDto memberDto = MemberMapper.INSTANCE.convertMemberToMemberDto(member);

        if(memberDto == null){
            log.warn("Failed at saving process!...");
        }
        else {
            log.info("New member has just successfully saved!...");
        }

        return memberDto;

    }

    public List<MemberDto> findAll() {

        List<Member> memberList = memberEntityService.findAll();

        List<MemberDto> memberDtoList = MemberMapper.INSTANCE.convertMemberListToMemberDtoList(memberList);

        if (memberDtoList.size()>0){
            log.info("Our list has just successfully been filled with members");
        }
        else {
            log.warn("The process could not find anything!...", new Throwable("Error in the finding process!"));
        }

        return memberDtoList;
    }

    public MemberDto findById(Long id) {

        Member member = findMemberById(id);

        MemberDto memberDto = MemberMapper.INSTANCE.convertMemberToMemberDto(member);

        if(memberDto == null){
            log.warn("Could not find any member with this id information!...");
        }
        else {
            log.info("Successfully found a member with this id information!...");
        }

        return memberDto;

    }

    public void delete(Long id) {

        Member member = findMemberById(id);

        memberEntityService.delete(member);

        log.info("The member has just successfully been deleted");

    }

    private Member findMemberById(Long id) {

        Member member;

        Optional<Member> optionalMember = memberEntityService.findById(id);

        if (optionalMember.isPresent()){

            member = optionalMember.get();

        }
        else {

            throw new RuntimeException("Member not found!");

        }

        return member;

    }

    public MemberDto findByPersonalNumber(String personalNumber){

        Member member = findMemberByPersonalNumber(personalNumber);

        MemberDto memberDto = MemberMapper.INSTANCE.convertMemberToMemberDto(member);

        if(memberDto == null){
            log.warn("Could not find any member with this personal number information!...");
        }
        else {
            log.info("Successfully found a member with this personal number information!...");
        }

        return memberDto;

    }

    private Member findMemberByPersonalNumber(String personalNumber) {

        Member member = memberEntityService.findByPersonalNumber(personalNumber);

        if (member == null){

            throw new RuntimeException("Member not found!");

        }

        return member;

    }

}
