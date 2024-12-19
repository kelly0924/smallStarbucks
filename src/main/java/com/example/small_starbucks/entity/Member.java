package com.example.small_starbucks.entity;

import com.example.small_starbucks.dto.Memberdto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Member {
    @Id //id Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;
    @Column
    private  String name;
    @Column
    private  String nickname;
    @Column
    private String email;
    @Column
    private  String password;
    public Memberdto toDto(Member entity){
        return  new Memberdto(entity.getAccount_id(), entity.getName(), entity.getEmail(), entity.getNickname(), entity.getPassword());
    }
}
