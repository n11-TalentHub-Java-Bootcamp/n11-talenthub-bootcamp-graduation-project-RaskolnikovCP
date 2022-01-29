package com.ozansaribal.n11bootcamp.graduation_project.Service;

import com.ozansaribal.n11bootcamp.graduation_project.Converter.CreditApplicationMapper;
import com.ozansaribal.n11bootcamp.graduation_project.Converter.MemberMapper;
import com.ozansaribal.n11bootcamp.graduation_project.Dto.CreditApplicationDto;
import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberDto;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.CreditApplication;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;
import com.ozansaribal.n11bootcamp.graduation_project.Enums.EnumCreditResultType;
import com.ozansaribal.n11bootcamp.graduation_project.Exception.MemberIdAndMemberBirthdateNotMatched;
import com.ozansaribal.n11bootcamp.graduation_project.Service.EntityService.CreditApplicationEntityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CreditApplicationService {

    private CreditApplicationEntityService creditApplicationEntityService;

    private CreditScoreService creditScoreService;

    private MemberService memberService;

    private final static double creditLimitMultiplier = 4.0;

    public List<CreditApplicationDto> findAll() {

        List<CreditApplication> creditApplicationList = creditApplicationEntityService.findAll();

        List<CreditApplicationDto> creditApplicationDtoList = CreditApplicationMapper.INSTANCE.convertCreditApplicationListToCreditApplicationDtoList(creditApplicationList);

        if (creditApplicationDtoList.size()>0){
            log.info("Our list has just successfully been filled with credit applications");
        }
        else {
            log.warn("The process could not find anything!...", new Throwable("Error in the finding process!"));
        }

        return creditApplicationDtoList;
    }

    public CreditApplicationDto update(CreditApplicationDto creditApplicationDto){

        CreditApplication creditApplication = CreditApplicationMapper.INSTANCE.convertCreditApplicationDtoToCreditApplication(creditApplicationDto);

        creditApplication = creditApplicationEntityService.save(creditApplication);

        if(creditApplication == null){
            log.warn("Updating application record has just been failed!...");
        }
        else {
            log.info("A credit application has just successfully been updated!...");
        }

        return creditApplicationDto;

    }

    public CreditApplicationDto create(Long memberId) {

        MemberDto memberDto = memberService.findById(memberId);

        if(isExistPreviousRecord(memberId)){
            log.warn("There are previous records of this member!...");
            throw new RuntimeException("There are already stored applications with this member");
        }

        Member member = MemberMapper.INSTANCE.convertMemberDtoToMember(memberDto);

        double creditLimit = calculateCreditLimit(member);

        EnumCreditResultType enumCreditResultType = calculateCreditResult(member);

        String telephoneNumber = member.getTelephoneNumber();

        CreditApplication creditApplication = new CreditApplication();

        creditApplication.setTelephoneNumber(telephoneNumber);

        creditApplication.setMember(member);

        creditApplication.setCreditLimit(creditLimit);

        creditApplication.setCreditResultType(enumCreditResultType);

        creditApplication = creditApplicationEntityService.save(creditApplication);

        CreditApplicationDto creditApplicationDto = CreditApplicationMapper.INSTANCE.convertCreditApplicationToCreditApplicationDto(creditApplication);

        if(creditApplicationDto == null){
            log.warn("This credit application is empty. Creating a new application is failed!...");
        }
        else {
            log.info("New credit application has just successfully been created!...");
        }

        return creditApplicationDto;

    }

    public boolean isExistPreviousRecord(Long memberId){

        CreditApplication creditApplication = creditApplicationEntityService.findByMemberIdAndByEnumResultType(memberId,EnumCreditResultType.APPROVED);

        boolean isExist = true;

        if(creditApplication == null){
            log.warn("This credit application does not exist.");
            isExist = false;
        }
        else {
            log.info("There is already a credit application with this member.");
        }

        return isExist;

    }

    public CreditApplicationDto findByMemberIdAndByBirthDate(String personalNumber, LocalDate birthDate){

        MemberDto memberDto = memberService.findByPersonalNumber(personalNumber);

        if(!memberDto.getBirthDate().isEqual(birthDate)){

            log.warn("These birthdate and personal number info are not matched!...");

            throw new MemberIdAndMemberBirthdateNotMatched(" personal number : " + personalNumber + " and " + birthDate + " are not matched. ");

        }

        CreditApplication creditApplication = creditApplicationEntityService.findByPersonalNumberAndByBirthDate(personalNumber,birthDate);

        CreditApplicationDto creditApplicationDto = CreditApplicationMapper.INSTANCE.convertCreditApplicationToCreditApplicationDto(creditApplication);

        if(creditApplicationDto == null){
            log.warn("There does not exist any member with this birthdate and personal number!...");
        }
        else {
            log.info("Successfully found a member with matched birthdate and personal number.");
        }

        return creditApplicationDto;

    }

    public Double calculateCreditLimit(Member member){

        //Long memberId = member.getId();

        if(member == null){
            log.warn("There does not exist any member!...");
        }
        else {
            log.info("Successfully found a member!...");
        }

        double monthlyIncome = member.getMonthlyIncome();

        double depositAmount = member.getDepositAmount();

        // here, I get the credit score using the member's id
        double creditScore = creditScoreService.findCreditScore(member);

        double creditLimit = 0.0;

        if(creditScore < 500){

            //denied
            //creditApplication.setCreditResultType(EnumCreditResultType.DENIED);
            //assign 0 credit limit
            creditLimit = 0L;

        }
        else if(creditScore > 500 && creditScore < 1000){

            if(monthlyIncome < 5000) {
                //approved
                //creditApplication.setCreditResultType(EnumCreditResultType.APPROVED);
                //assign 10.000 credit limit
                creditLimit=10.000;

                if (depositAmount>0) {

                    // calculate %10 of deposit amount

                    depositAmount = (depositAmount/10);

                    // add and assign this new calculation into the credit limit

                    creditLimit += depositAmount;

                }
            }
            else if (monthlyIncome > 5000 && monthlyIncome < 10000){
                // approved
                // creditApplication.setCreditResultType(EnumCreditResultType.APPROVED);
                // assign 20.000 credit limit
                creditLimit=20.000;

                if(depositAmount>0){
                    // calculate %20 of deposit amount

                    depositAmount = (depositAmount/5);

                    // add and assign this new calculation into the credit limit

                    creditLimit += depositAmount;

                }

            }
            else if (monthlyIncome > 10000){
                // approved
                // creditApplication.setCreditResultType(EnumCreditResultType.APPROVED);
                // calculate ((MONTHLY INCOME INFO * CREDIT LIMIT MULTIPLIER) / 2)

                // assign this calculation as credit limit
                creditLimit = ((monthlyIncome*creditLimitMultiplier) / 2);

                if(depositAmount>0){
                    // calculate %25 of deposit amount

                    depositAmount = (depositAmount/4);

                    // add and assign this new calculation into the credit limit

                    creditLimit += depositAmount;

                }

            }

        }
        else if (creditScore >= 1000){

            // approved
            // creditApplication.setCreditResultType(EnumCreditResultType.APPROVED);
            // calculate (MONTHLY INCOME INFO * CREDIT LIMIT MULTIPLIER)

            // assign this calculation as credit limit
            creditLimit = (monthlyIncome*creditLimitMultiplier);

            if(depositAmount>0){
                // calculate %50 of deposit amount

                depositAmount = (depositAmount/2);

                // add and assign this new calculation into the credit limit

                creditLimit += depositAmount;

            }

        }

        log.info("Credit limit is successfully calculated");

        return creditLimit;

    }

    public EnumCreditResultType calculateCreditResult(Member member){

        //Long memberId = member.getId();

        if(member == null){
            log.warn("There does not exist any member!...");
        }
        else {
            log.info("Successfully found a member!...");
        }

        double monthlyIncome = member.getMonthlyIncome();

        // here, I get the credit score using the member's id
        double creditScore = creditScoreService.findCreditScore(member);

        EnumCreditResultType enumCreditResultType = null;

        if(creditScore < 500){

            //denied

            enumCreditResultType = EnumCreditResultType.DENIED;

        }
        else if(creditScore > 500 && creditScore < 1000){

            if(monthlyIncome < 5000) {
                //approved

                enumCreditResultType = EnumCreditResultType.APPROVED;

            }
            else if (monthlyIncome > 5000 && monthlyIncome < 10000){
                // approved

                enumCreditResultType = EnumCreditResultType.APPROVED;

            }
            else if (monthlyIncome > 10000){
                // approved

                enumCreditResultType = EnumCreditResultType.APPROVED;

            }

        }
        else if (creditScore >= 1000){

            // approved

            enumCreditResultType = EnumCreditResultType.APPROVED;

        }

        log.info("Credit result is successfully calculated");

        return enumCreditResultType;

    }

}
