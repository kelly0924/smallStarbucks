package com.example.small_starbucks.api;

import com.example.small_starbucks.dto.CoffeeDto;
import com.example.small_starbucks.entity.Coffee;
import com.example.small_starbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
