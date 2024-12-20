package com.example.small_starbucks.service;

import com.example.small_starbucks.dto.Memberdto;
import com.example.small_starbucks.entity.Member;
import com.example.small_starbucks.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public Memberdto update(Long accountIndex, Memberdto dto) {
        //dto->entity로 변환
        Member entity = dto.toEntity();
        Member targetEntity = memberRepository.findById(accountIndex).orElse(null);
        //수정하고자 하는 회원이 존재 하지 않을 경우 예외 처리
        if(accountIndex != entity.getAccount_id() || targetEntity.getAccount_id() == null) {
            throw new IllegalArgumentException("id가 존재하지 않습니다.");
        }
        Member updateData = memberRepository.save(entity);
        Memberdto updatedMember = updateData.toDto(updateData);

        return updatedMember;
    }

    public Memberdto delete(Long accountIndex) {
        //target enetity 가져오기
        Member target = memberRepository.findById(accountIndex).orElse(null);
        Memberdto deletedDto = target.toDto(target);
        if(target.getAccount_id() == null || target.getAccount_id() != accountIndex){
            throw new IllegalArgumentException("회원 id가 존재 하지 않습니다. ");
        }
        memberRepository.delete(target);
        return deletedDto;
    }
}
