package com.example.small_starbucks.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
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


}
