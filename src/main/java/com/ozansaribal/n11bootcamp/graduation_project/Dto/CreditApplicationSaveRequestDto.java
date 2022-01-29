package com.ozansaribal.n11bootcamp.graduation_project.Dto;

import com.ozansaribal.n11bootcamp.graduation_project.Enums.EnumCreditResultType;
import lombok.Data;

@Data
public class CreditApplicationSaveRequestDto {

    //private Long id;
    private Long memberId;
    private String telephoneNumber;
    private EnumCreditResultType creditResultType;
    private Double creditLimit;

}
