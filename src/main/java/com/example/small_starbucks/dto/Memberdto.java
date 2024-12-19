package com.example.small_starbucks.dto;

import com.example.small_starbucks.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Memberdto {
    private Long account_id;
    private String name;
    private String email;
    private  String nickname;
    private String password;

    //dio->entity로 변환하기
    public Member toEntity(){
        return new Member(account_id, name,email,nickname, password);
    }
}
