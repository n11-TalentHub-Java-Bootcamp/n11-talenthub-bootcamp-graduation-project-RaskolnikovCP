package com.ozansaribal.n11bootcamp.graduation_project.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MemberDto {

    private Long id;
    private String personalNumber;
    private String firstName;
    private String lastName;
    private Double monthlyIncome;
    private String telephoneNumber;
    private LocalDate birthDate;
    private Double depositAmount;
    private Double creditScore;


}
