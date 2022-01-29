package com.ozansaribal.n11bootcamp.graduation_project.Service.EntityService;

import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;
import com.ozansaribal.n11bootcamp.graduation_project.Repositories.MemberRepositories;
import org.springframework.stereotype.Service;

@Service
public class MemberEntityService extends BaseEntityService<Member, MemberRepositories> {

    public MemberEntityService(MemberRepositories dao) {
        super(dao);
    }

    public Member findByPersonalNumber(String personalNumber){

        return getDao().findByPersonalNumber(personalNumber);

    }

}
