package com.example.small_starbucks.dto;

import com.example.small_starbucks.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

}
