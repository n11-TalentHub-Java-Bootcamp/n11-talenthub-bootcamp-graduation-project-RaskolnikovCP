package com.ozansaribal.n11bootcamp.graduation_project.Service;

import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;
import com.ozansaribal.n11bootcamp.graduation_project.Service.EntityService.MemberEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditScoreServiceTest {

    @Mock
    private MemberEntityService memberEntityService;

    @InjectMocks
    private CreditScoreService creditScoreService;

    @Test
    void shouldFindCreditScore() {

        Member member = MemberDataProvider.getMember();

        double creditScore = creditScoreService.findCreditScore(member);

        when(memberEntityService.getById(any())).thenReturn(member);

        double resultScore = member.getCreditScore();

        assertEquals(creditScore,resultScore);

    }

}