package com.ozansaribal.n11bootcamp.graduation_project.Service;

import com.ozansaribal.n11bootcamp.graduation_project.Converter.CreditApplicationMapper;
import com.ozansaribal.n11bootcamp.graduation_project.Dto.CreditApplicationDto;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.CreditApplication;
import com.ozansaribal.n11bootcamp.graduation_project.Entity.Member;
import com.ozansaribal.n11bootcamp.graduation_project.Enums.EnumCreditResultType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreditApplicationDataProvider {

    public static List<CreditApplicationDto> convertCreditApplicationToCreditApplicationDto(List<CreditApplication> creditApplicationList) {
        List<CreditApplicationDto> creditApplicationDtoList = CreditApplicationMapper.INSTANCE
                .convertCreditApplicationListToCreditApplicationDtoList(creditApplicationList);
        return creditApplicationDtoList;
    }

    public static CreditApplication convertCreditApplicationDtoToCreditApplication(CreditApplicationDto creditApplicationDto) {
        CreditApplication creditApplication = CreditApplicationMapper.INSTANCE
                .convertCreditApplicationDtoToCreditApplication(creditApplicationDto);
        return creditApplication;
    }

    public static CreditApplication getCreditApplication(){

        CreditApplication creditApplication1 = new CreditApplication();
        creditApplication1.setId(1L);
        creditApplication1.setCreditLimit(0.0);
        creditApplication1.setTelephoneNumber("05346667788");
        creditApplication1.setCreditResultType(EnumCreditResultType.DENIED);
        creditApplication1.setMember(new Member(1L,"19938820055","first_name_1","last_name_1",3500.0,creditApplication1.getTelephoneNumber(), LocalDate.parse("1994-04-21"),4500.0,((3500.0*8)/100.0)));

        return creditApplication1;

    }

    public static CreditApplicationDto getCreditApplicationDto(Long id){

        CreditApplicationDto creditApplicationDto1 = new CreditApplicationDto();
        creditApplicationDto1.setId(id);
        creditApplicationDto1.setMemberId(1L);
        creditApplicationDto1.setTelephoneNumber("05346667788");
        creditApplicationDto1.setCreditResultType(EnumCreditResultType.DENIED);
        creditApplicationDto1.setCreditLimit(0.0);

        return creditApplicationDto1;

    }

    public static List<CreditApplication> getAllCreditApplicationList(){

        List<CreditApplication> creditApplicationList = new ArrayList<>();

        CreditApplication creditApplication1 = new CreditApplication();
        creditApplication1.setId(1L);
        creditApplication1.setCreditLimit(0.0);
        creditApplication1.setTelephoneNumber("05346667788");
        creditApplication1.setCreditResultType(EnumCreditResultType.DENIED);
        creditApplication1.setMember(new Member(1L,"19938820055","first_name_1","last_name_1",3500.0,creditApplication1.getTelephoneNumber(), LocalDate.parse("1994-04-21"),4500.0,((3500.0*8)/100.0)));
        creditApplicationList.add(creditApplication1);

        CreditApplication creditApplication2 = new CreditApplication();
        creditApplication2.setId(2L);
        creditApplication2.setCreditLimit(0.0);
        creditApplication2.setTelephoneNumber("05336578979");
        creditApplication2.setCreditResultType(EnumCreditResultType.DENIED);
        creditApplication2.setMember(new Member(2L,"29486710988","first_name_2","last_name_2",5000.0,creditApplication2.getTelephoneNumber(), LocalDate.parse("1987-09-19"),2700.0,((5000.0*8)/100.0)));
        creditApplicationList.add(creditApplication1);


        CreditApplication creditApplication3 = new CreditApplication();
        creditApplication3.setId(3L);
        creditApplication3.setCreditLimit(27000.0);
        creditApplication3.setTelephoneNumber("05346947690");
        creditApplication3.setCreditResultType(EnumCreditResultType.APPROVED);
        creditApplication3.setMember(new Member(3L,"28848891292","first_name_3","last_name_3",12000.0,creditApplication3.getTelephoneNumber(), LocalDate.parse("1982-02-22"),12000.0,((12000.0*8)/100.0)));
        creditApplicationList.add(creditApplication3);


        CreditApplication creditApplication4 = new CreditApplication();
        creditApplication4.setId(4L);
        creditApplication4.setCreditLimit(22000.0);
        creditApplication4.setTelephoneNumber("05456785949");
        creditApplication4.setCreditResultType(EnumCreditResultType.APPROVED);
        creditApplication4.setMember(new Member(4L,"34556723456","first_name_4","last_name_4",10000.0,creditApplication4.getTelephoneNumber(), LocalDate.parse("1978-05-15"),8000.0,((10000.0*8)/100.0)));
        creditApplicationList.add(creditApplication4);


        CreditApplication creditApplication5 = new CreditApplication();
        creditApplication5.setId(5L);
        creditApplication5.setCreditLimit(148000.0);
        creditApplication5.setTelephoneNumber("05229558456");
        creditApplication5.setCreditResultType(EnumCreditResultType.APPROVED);
        creditApplication5.setMember(new Member(5L,"36699923457","first_name_5","last_name_5",35000.0,creditApplication5.getTelephoneNumber(), LocalDate.parse("1975-11-05"),16000.0,((35000.0*8)/100.0)));
        creditApplicationList.add(creditApplication5);

        return creditApplicationList;

    }

    public static List<CreditApplicationDto> getAllCreditApplicationDtoList(){

        List<CreditApplicationDto> creditApplicationDtoList = new ArrayList<>();

        CreditApplicationDto creditApplicationDto1 = new CreditApplicationDto();
        creditApplicationDto1.setId(1L);
        creditApplicationDto1.setMemberId(1L);
        creditApplicationDto1.setTelephoneNumber("05346667788");
        creditApplicationDto1.setCreditResultType(EnumCreditResultType.DENIED);
        creditApplicationDto1.setCreditLimit(0.0);
        creditApplicationDtoList.add(creditApplicationDto1);

        CreditApplicationDto creditApplicationDto2 = new CreditApplicationDto();
        creditApplicationDto2.setId(2L);
        creditApplicationDto2.setMemberId(2L);
        creditApplicationDto2.setTelephoneNumber("05336578979");
        creditApplicationDto2.setCreditResultType(EnumCreditResultType.DENIED);
        creditApplicationDto2.setCreditLimit(0.0);
        creditApplicationDtoList.add(creditApplicationDto2);


        CreditApplicationDto creditApplicationDto3 = new CreditApplicationDto();
        creditApplicationDto3.setId(3L);
        creditApplicationDto3.setMemberId(3L);
        creditApplicationDto3.setTelephoneNumber("05346947690");
        creditApplicationDto3.setCreditResultType(EnumCreditResultType.APPROVED);
        creditApplicationDto3.setCreditLimit(27000.0);
        creditApplicationDtoList.add(creditApplicationDto3);


        CreditApplicationDto creditApplicationDto4 = new CreditApplicationDto();
        creditApplicationDto4.setId(4L);
        creditApplicationDto4.setMemberId(4L);
        creditApplicationDto4.setTelephoneNumber("05456785949");
        creditApplicationDto4.setCreditResultType(EnumCreditResultType.APPROVED);
        creditApplicationDto4.setCreditLimit(22000.0);
        creditApplicationDtoList.add(creditApplicationDto4);


        CreditApplicationDto creditApplicationDto5 = new CreditApplicationDto();
        creditApplicationDto5.setId(5L);
        creditApplicationDto5.setMemberId(5L);
        creditApplicationDto5.setTelephoneNumber("05229558456");
        creditApplicationDto5.setCreditResultType(EnumCreditResultType.APPROVED);
        creditApplicationDto5.setCreditLimit(148000.0);
        creditApplicationDtoList.add(creditApplicationDto5);


        return creditApplicationDtoList;

    }

}
