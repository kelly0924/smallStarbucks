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

}
