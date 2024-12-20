package com.example.small_starbucks.api;

import com.example.small_starbucks.dto.CoffeeDto;
import com.example.small_starbucks.dto.Memberdto;
import com.example.small_starbucks.entity.Coffee;
import com.example.small_starbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CoffeeRestApi {

    @Autowired
    private CoffeeService coffeeService;
    //커피 메뉴를 저장하는 api
    @PostMapping("/coffee")
    public ResponseEntity<CoffeeDto> save(@RequestBody CoffeeDto dto){
        log.info("요청에서?: ", dto.toEntity());
        CoffeeDto coffeeDto = coffeeService.save(dto);
        return ResponseEntity.status(HttpStatus.OK).body(coffeeDto);
    }

    //커피 메뉴 전체 가져오기
    @GetMapping("/coffeelist")
    public ResponseEntity<List<CoffeeDto>> coffeeList(){
       List<CoffeeDto> listData = coffeeService.showList();
        return ResponseEntity.status(HttpStatus.OK).body(listData);
    }

    //커피 메뉴 자세히 보기
    @GetMapping("/coffee/{coffee_index}")
    public ResponseEntity<CoffeeDto> show(@PathVariable Long coffee_index){
        CoffeeDto showCoffee = coffeeService.show(coffee_index);
        return ResponseEntity.status(HttpStatus.OK).body(showCoffee);
    }

    //커피 메뉴 수정 하기
    @PatchMapping("/coffee/{coffee_index}")
    public ResponseEntity<CoffeeDto> update(@PathVariable Long coffee_index, @RequestBody CoffeeDto dto){
        CoffeeDto updated = coffeeService.update(coffee_index,dto);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

}
