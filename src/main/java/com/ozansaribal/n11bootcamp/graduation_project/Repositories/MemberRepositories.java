package com.ozansaribal.n11bootcamp.graduation_project.Repositories;

import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepositories extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.personalNumber = :personalNumber")
    public Member findByPersonalNumber(String personalNumber);

}
