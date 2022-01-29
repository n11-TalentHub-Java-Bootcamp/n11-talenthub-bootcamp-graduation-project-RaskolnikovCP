package com.ozansaribal.n11bootcamp.graduation_project.Converter;

import com.ozansaribal.n11bootcamp.graduation_project.Dto.CreditApplicationDto;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.CreditApplication;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditApplicationMapper {

    CreditApplicationMapper INSTANCE = Mappers.getMapper(CreditApplicationMapper.class);

    @Mapping(source = "member.id", target = "memberId")
    CreditApplicationDto convertCreditApplicationToCreditApplicationDto(CreditApplication creditApplication);

    //CreditApplication convertCreditApplicationSaveRequestToCreditApplication(CreditApplicationSaveRequestDto creditApplicationSaveRequestDto);

    @Mapping(source = "member.id", target = "memberId")
    List<CreditApplicationDto> convertCreditApplicationListToCreditApplicationDtoList(List<CreditApplication> creditApplicationList);

    //CreditApplication convertCreditApplicationSaveRequestDtoToCreditApplication(CreditApplicationSaveRequestDto creditApplicationSaveRequestDto);

    //CreditApplicationDto convertCreditApplicationSaveRequestDtoToCreditApplicationDto(CreditApplicationSaveRequestDto creditApplicationSaveRequestDto);

    @Mapping(source = "memberId", target = "member.id")
    CreditApplication convertCreditApplicationDtoToCreditApplication(CreditApplicationDto creditApplicationDto);

    @AfterMapping()
    default void setNulls(@MappingTarget() final CreditApplication creditApplication, CreditApplicationDto creditApplicationDto){
        if(creditApplicationDto.getMemberId()==null){
            creditApplication.setMember(null);
        }
    }

}
