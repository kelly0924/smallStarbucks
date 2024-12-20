package com.example.small_starbucks.api;

import com.example.small_starbucks.dto.Memberdto;
import com.example.small_starbucks.entity.Member;
import com.example.small_starbucks.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
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
    //회원 정보 보기
    @GetMapping("/account/{account_index}")
    public ResponseEntity<Memberdto> show(@PathVariable Long account_index){
        Memberdto memberData = memberService.show(account_index);
        return ResponseEntity.status(HttpStatus.OK).body(memberData);
    }

    @PatchMapping("/account/{account_index}")
    public ResponseEntity<Memberdto> update(@PathVariable("account_index") Long account_index, @RequestBody Memberdto dto) {
        log.info("PathVariable: account_index = {}", account_index);
        log.info("RequestBody: {}", dto);

        Memberdto updated = memberService.update(account_index, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
   //회원 정보 삭제 하기
    @DeleteMapping("/account/{account_index}")
    public ResponseEntity<Memberdto> delete(@PathVariable Long account_index){
        Memberdto memberdto = memberService.delete(account_index);
        return ResponseEntity.status(HttpStatus.OK).body(memberdto);
    }

}
