package com.example.small_starbucks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@ToString
@Getter
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long coffee_index;

    @Column
    private String menu;

    @Column
    private  String details;

    @Column
    private  String calories;

}
