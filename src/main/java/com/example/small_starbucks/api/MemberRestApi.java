package com.example.small_starbucks.api;

import com.example.small_starbucks.dto.Memberdto;
import com.example.small_starbucks.entity.Member;
import com.example.small_starbucks.service.MemberService;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestApi {
    @Autowired
    private  MemberService memberService;
    @PostMapping("/account")
    public  ResponseEntity<Memberdto>save(@RequestBody Memberdto dto){// 요청으로 들어 오는 값은 객체로 받기
        //객체를 entity
        Member memeberEntity = dto.toEntity();

        Memberdto saved = memberService.save(memeberEntity);
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }
}
