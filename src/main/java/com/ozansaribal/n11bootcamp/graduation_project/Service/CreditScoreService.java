package com.ozansaribal.n11bootcamp.graduation_project.Service;

import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CreditScoreService {

    public Double findCreditScore(Member member){

        if(member == null){
            log.warn("There does not exist any member!...");
        }
        else {
            log.info("Successfully found a member!...");
        }

        double income = member.getMonthlyIncome();

        double creditScore;

        if(member.getCreditScore() == null || member.getCreditScore() <= 0){

            creditScore = 0.0;

        }
        else {

            creditScore = ((income*8)/100.0);

        }

        log.info("Credit score is successfully calculated");

        return creditScore;

    }

}
