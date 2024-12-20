package com.example.small_starbucks.dto;

import com.example.small_starbucks.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CoffeeDto {
    private Long coffee_index;
    private String menu;
    private String details;
    private  String calories;

    //dto ->entity로 변환 하기
    public Coffee toEntity(){
        return new Coffee(coffee_index, menu, details, calories);
    }

    //entity->dto로 변환 하기
    public static CoffeeDto toDtio(Coffee entity){
        return new CoffeeDto(
                entity.getCoffee_index(),
                entity.getMenu(),
                entity.getDetails(),
                entity.getCalories()
        );

    }

    //entry List를 -> dtoList 변환하기
    public  static List<CoffeeDto> toDtoList(List<Coffee> entityList){
        return entityList.stream()
                .map(coffee ->new CoffeeDto( coffee.getCoffee_index(),
                        coffee.getMenu(),
                        coffee.getDetails(),
                        coffee.getCalories()))
                .collect(Collectors.toList());
    }
}
