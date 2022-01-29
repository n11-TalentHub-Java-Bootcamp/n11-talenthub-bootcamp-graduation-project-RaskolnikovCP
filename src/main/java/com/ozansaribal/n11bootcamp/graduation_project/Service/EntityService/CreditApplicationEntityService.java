package com.ozansaribal.n11bootcamp.graduation_project.Service.EntityService;

import com.ozansaribal.n11bootcamp.graduation_project.Entity.CreditApplication;
import com.ozansaribal.n11bootcamp.graduation_project.Enums.EnumCreditResultType;
import com.ozansaribal.n11bootcamp.graduation_project.Repositories.CreditApplicationRepositories;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditApplicationEntityService extends BaseEntityService<CreditApplication, CreditApplicationRepositories> {

    public CreditApplicationEntityService(CreditApplicationRepositories dao) {
        super(dao);
    }

    public CreditApplication findByPersonalNumberAndByBirthDate(String personalNumber, LocalDate birthDate){

        return getDao().findByPersonalNumberAndByBirthDate(personalNumber, birthDate);

    }

    public CreditApplication findByMemberIdAndByEnumResultType(Long memberId, EnumCreditResultType enumCreditResultType){

        return getDao().findByMemberIdAndByEnumResultType(memberId, enumCreditResultType);

    }
/*
    public CreditApplication findByMemberIdAndByEnumResultType(Long memberId, EnumCreditResultType enumCreditResultType){

        return getDao().findByMemberId(memberId);

    }*/

}
