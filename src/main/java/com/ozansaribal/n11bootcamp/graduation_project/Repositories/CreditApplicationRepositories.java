package com.ozansaribal.n11bootcamp.graduation_project.Repositories;

import com.ozansaribal.n11bootcamp.graduation_project.Entity.CreditApplication;
import com.ozansaribal.n11bootcamp.graduation_project.Enums.EnumCreditResultType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CreditApplicationRepositories extends JpaRepository<CreditApplication, Long> {

    @Query("select creditApplication from CreditApplication creditApplication where creditApplication.member.personalNumber = :personalNumber and creditApplication.member.birthDate = :birthDate order by creditApplication.id")
    public CreditApplication findByPersonalNumberAndByBirthDate(String personalNumber, LocalDate birthDate);

    @Query("select creditApplication from CreditApplication creditApplication where creditApplication.member.id = :memberId and creditApplication.creditResultType = :enumCreditResultType")
    public CreditApplication findByMemberIdAndByEnumResultType(Long memberId, EnumCreditResultType enumCreditResultType);

    //public CreditApplication findByMemberId(Long memberId);

}
