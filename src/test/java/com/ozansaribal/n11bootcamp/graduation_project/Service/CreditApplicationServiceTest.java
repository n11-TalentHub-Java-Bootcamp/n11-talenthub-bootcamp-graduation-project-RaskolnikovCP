package com.ozansaribal.n11bootcamp.graduation_project.Service;

import com.ozansaribal.n11bootcamp.graduation_project.Dto.CreditApplicationDto;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.CreditApplication;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;
import com.ozansaribal.n11bootcamp.graduation_project.Enums.EnumCreditResultType;
import com.ozansaribal.n11bootcamp.graduation_project.Service.EntityService.CreditApplicationEntityService;
import com.ozansaribal.n11bootcamp.graduation_project.Service.EntityService.MemberEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditApplicationServiceTest {

    @Mock
    private CreditApplicationEntityService creditApplicationEntityService;

    @Mock
    private MemberEntityService memberEntityService;

    @InjectMocks
    private CreditApplicationService creditApplicationService;

    @Test
    void shouldFindAllExist() {

        List<CreditApplication> creditApplicationList = CreditApplicationDataProvider.getAllCreditApplicationList();

        List<CreditApplicationDto> creditApplicationDtoList = CreditApplicationDataProvider.convertCreditApplicationToCreditApplicationDto(creditApplicationList);

        when(creditApplicationEntityService.findAll()).thenReturn(creditApplicationList);

        List<CreditApplicationDto> dtoList = creditApplicationService.findAll();

        assertArrayEquals(creditApplicationDtoList.toArray(), dtoList.toArray());
    }

    @Test
    void shouldFindAllDoesNotExist() {

        List<CreditApplication> arrayList = new ArrayList<>();

        List<CreditApplicationDto> creditApplicationDtoList = CreditApplicationDataProvider.convertCreditApplicationToCreditApplicationDto(arrayList);

        when(creditApplicationEntityService.findAll()).thenReturn(arrayList);

        List<CreditApplicationDto> dtoList = creditApplicationService.findAll();

        assertArrayEquals(creditApplicationDtoList.toArray(), dtoList.toArray());
    }
    /*
    @Test
    void findAll() {
    }*/

    @Test
    void shouldUpdate() {

        CreditApplicationDto creditApplicationDto = CreditApplicationDataProvider.getCreditApplicationDto(null);

        CreditApplication creditApplicationSaved = CreditApplicationDataProvider.getCreditApplication();

        when(creditApplicationEntityService.save(ArgumentMatchers.any(CreditApplication.class))).thenReturn(creditApplicationSaved);

        CreditApplicationDto resultDto = creditApplicationService.update(creditApplicationDto);

        CreditApplication result = CreditApplicationDataProvider.convertCreditApplicationDtoToCreditApplication(resultDto);

        assertEquals(creditApplicationSaved, result);

        assertEquals(1L, result.getId());

    }

    @Test
    void shouldCreate() {

        CreditApplication creditApplicationSaved = CreditApplicationDataProvider.getCreditApplication();

        when(creditApplicationEntityService.save(ArgumentMatchers.any(CreditApplication.class))).thenReturn(creditApplicationSaved);

        CreditApplicationDto resultDto = creditApplicationService.create(1L);

        CreditApplication result = CreditApplicationDataProvider.convertCreditApplicationDtoToCreditApplication(resultDto);

        assertEquals(creditApplicationSaved, result);

        assertEquals(1L, result.getId());

    }

    @Test
    void shouldExistPreviousRecord() {

        boolean isCreditApplicationPreviousRecordExist = creditApplicationService.isExistPreviousRecord(1L);

        when(creditApplicationService.isExistPreviousRecord(1L)).thenReturn(isCreditApplicationPreviousRecordExist);

        // I tried to check as the first record. Because the new member record should not contain any previous application record
        assertFalse(isCreditApplicationPreviousRecordExist);

    }

    @Test
    void shouldFindByMemberIdAndByBirthDate() {

        CreditApplication creditApplication = CreditApplicationDataProvider.getCreditApplication();

        CreditApplicationDto creditApplicationDto = CreditApplicationDataProvider.getCreditApplicationDto(1L);

        when(creditApplicationEntityService.findByPersonalNumberAndByBirthDate(any(), any())).thenReturn(creditApplication);

        CreditApplicationDto result = creditApplicationService.findByMemberIdAndByBirthDate("19938820055",LocalDate.parse("1994-04-21"));

        assertEquals(creditApplicationDto, result);

    }

    @Test
    void shouldCalculateCreditLimit() {

        Member member = MemberDataProvider.getMember();

        double calculateCreditLimit = creditApplicationService.calculateCreditLimit(member);

        when(memberEntityService.getById(any())).thenReturn(member);

        double result = member.getCreditScore();

        assertEquals(calculateCreditLimit, result);

    }

    @Test
    void shouldCalculateCreditResult() {

        CreditApplication creditApplication = CreditApplicationDataProvider.getCreditApplication();

        Member member = MemberDataProvider.getMember();

        EnumCreditResultType enumCreditResultType = creditApplicationService.calculateCreditResult(member);

        when(creditApplicationEntityService.getById(any())).thenReturn(creditApplication);

        EnumCreditResultType resultType = creditApplication.getCreditResultType();

        assertEquals(enumCreditResultType,resultType);

    }

}