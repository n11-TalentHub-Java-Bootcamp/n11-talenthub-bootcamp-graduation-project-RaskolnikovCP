package com.ozansaribal.n11bootcamp.graduation_project.Service;

import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberDto;
import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberSaveRequestDto;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;
import com.ozansaribal.n11bootcamp.graduation_project.Service.EntityService.MemberEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberEntityService memberEntityService;

    @InjectMocks
    private MemberService memberService;

    @Test
    void shouldSave() {

        MemberSaveRequestDto memberSaveRequestDto = MemberDataProvider.getMemberSaveRequestDto(null);

        Member memberSaved = MemberDataProvider.getMember();

        when(memberEntityService.save(ArgumentMatchers.any(Member.class))).thenReturn(memberSaved);

        MemberDto resultDto = memberService.save(memberSaveRequestDto);

        Member result = MemberDataProvider.convertMemberDtoToMember(resultDto);

        assertEquals(memberSaved, result);
        assertEquals(1L, result.getId());

    }

    @Test
    void shouldFindAllExist() {

        List<Member> memberList = MemberDataProvider.getAllMemberList();

        List<MemberDto> memberDtoList = MemberDataProvider.convertMemberListToMemberDtoList(memberList);

        when(memberEntityService.findAll()).thenReturn(memberList);

        List<MemberDto> saveMemberDtoList = memberService.findAll();

        assertArrayEquals(memberDtoList.toArray(), saveMemberDtoList.toArray());

    }

    @Test
    void shouldFindAllDoesNotExist() {

        List<Member> arrayList = new ArrayList<>();

        List<MemberDto> memberDtoList = MemberDataProvider.convertMemberListToMemberDtoList(arrayList);

        when(memberEntityService.findAll()).thenReturn(arrayList);

        List<MemberDto> saveMemberDtoList = memberService.findAll();

        assertArrayEquals(memberDtoList.toArray(), saveMemberDtoList.toArray());

    }

/*
    @Test
    void findAll() {
    }
*/
    @Test
    void shouldFindById() {

        Member member = MemberDataProvider.getMember();

        MemberDto memberDto = MemberDataProvider.getMemberDto(1L);

        when(memberEntityService.getById(any())).thenReturn(member);

        MemberDto result = memberService.findById(1L);

        assertEquals(memberDto, result);

    }

    @Test
    void findMemberById_shouldIdDoesNotExist() {

        when(memberEntityService.getById(0L)).thenThrow(new RuntimeException("Category not found!"));

        assertThrows(RuntimeException.class, () -> memberService.findById(0L));

    }

    @Test
    void shouldDelete() {

        Member member = MemberDataProvider.getMember();

        when(memberEntityService.getById(anyLong())).thenReturn(member);

        memberService.delete(1L);

        verify(memberEntityService).getById(anyLong());
        verify(memberEntityService).delete(member);

    }

    @Test
    void delete_shouldIdDoesNotExist() {

        when(memberEntityService.getById(0L)).thenThrow(new RuntimeException("Category not found!"));

        assertThrows(RuntimeException.class, () -> memberService.delete(0L));
        verify(memberEntityService).getById(anyLong());

    }

    @Test
    void shouldFindByPersonalNumber() {

        Member member = MemberDataProvider.getMember();

        MemberDto memberDto = MemberDataProvider.getMemberDtoByPersonalNumber("19938820055");

        when(memberEntityService.getById(any())).thenReturn(member);

        MemberDto result = memberService.findByPersonalNumber("19938820055");

        assertEquals(memberDto, result);

    }

}