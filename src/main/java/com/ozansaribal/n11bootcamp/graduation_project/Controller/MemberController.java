package com.ozansaribal.n11bootcamp.graduation_project.Controller;

import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberDto;
import com.ozansaribal.n11bootcamp.graduation_project.Dto.MemberSaveRequestDto;
import com.ozansaribal.n11bootcamp.graduation_project.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@AllArgsConstructor
@CrossOrigin
public class MemberController {

    private MemberService memberService;

    @PostMapping
    public ResponseEntity create(@RequestBody MemberSaveRequestDto memberSaveRequestDto){

        MemberDto memberDto = memberService.save(memberSaveRequestDto);

        return ResponseEntity.ok(memberDto);

    }

    @GetMapping
    public ResponseEntity findAll(){

        List<MemberDto> memberDtoList = memberService.findAll();

        return ResponseEntity.ok(memberDtoList);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        memberService.delete(id);
    }

}
