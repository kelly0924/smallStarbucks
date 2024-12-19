package com.example.small_starbucks.service;

import com.example.small_starbucks.dto.Memberdto;
import com.example.small_starbucks.entity.Member;
import com.example.small_starbucks.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public  Memberdto save(Member entity){
      Member savedData = memberRepository.save(entity);
      Memberdto dto = savedData.toDto(savedData);
      return dto;
    }

    public Memberdto show(Long accountIndex) {
        //data base에 account_index 가져오기
        Member entity = memberRepository.findById(accountIndex).orElse(null);
        // 검사 하기
        if(accountIndex != entity.getAccount_id() || entity.getAccount_id() == null){
           throw new IllegalArgumentException("회원 정보 보기 실패:  회원 id가 없습니다.");
        }
        Memberdto dto = entity.toDto(entity);
        return dto;
    }
}
