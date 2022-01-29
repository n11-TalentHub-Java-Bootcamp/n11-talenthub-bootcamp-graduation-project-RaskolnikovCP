package com.ozansaribal.n11bootcamp.graduation_project.Controller;

import com.ozansaribal.n11bootcamp.graduation_project.Dto.CreditApplicationDto;
import com.ozansaribal.n11bootcamp.graduation_project.Service.CreditApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/credit-applications")
@AllArgsConstructor
@CrossOrigin
public class CreditApplicationController {

    private CreditApplicationService creditApplicationService;


    @PostMapping("/update")
    public ResponseEntity update(@RequestBody CreditApplicationDto creditApplicationDto){

        CreditApplicationDto creditApplicationDto1 = creditApplicationService.update(creditApplicationDto);

        return ResponseEntity.ok(creditApplicationDto1);

    }

    @PostMapping("/create/{memberId}")
    public ResponseEntity create(@PathVariable Long memberId){

        CreditApplicationDto creditApplicationDto = creditApplicationService.create(memberId);

        return ResponseEntity.ok(creditApplicationDto.getCreditResultType());

    }

    @GetMapping
    public ResponseEntity findAll(){

        List<CreditApplicationDto> creditApplicationDtoList = creditApplicationService.findAll();

        return ResponseEntity.ok(creditApplicationDtoList);
    }

    @GetMapping("/{personalNumber}/{birthDate}")
    public ResponseEntity findByIdAndByBirthDate(@PathVariable String personalNumber, @PathVariable String birthDate){

        LocalDate localDate = LocalDate.parse(birthDate);

        CreditApplicationDto creditApplicationDto = creditApplicationService.findByMemberIdAndByBirthDate(personalNumber, localDate);

        return ResponseEntity.ok(creditApplicationDto);

    }

}
