package com.example.small_starbucks.service;

import com.example.small_starbucks.dto.CoffeeDto;
import com.example.small_starbucks.dto.Memberdto;
import com.example.small_starbucks.entity.Coffee;
import com.example.small_starbucks.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public CoffeeDto save(CoffeeDto dto) {
        //dto -> entity로 변환
        Coffee entity = dto.toEntity();
        log.info("객체", dto.toEntity());
        log.info("enity: ", entity.toString());
        Coffee coffeeEntity = coffeeRepository.save(entity);
        CoffeeDto saved = CoffeeDto.toDtio(coffeeEntity);
        return saved;
    }

    public List<CoffeeDto> showList() {
        List<Coffee> entityList = coffeeRepository.findAll();
        log.info("entityList: " ,entityList.stream().toList());
        List<CoffeeDto> dtoList =CoffeeDto.toDtoList(entityList);
        return dtoList;
    }

    public CoffeeDto show(Long coffeeIndex) {
        //entity 가져오기
        Coffee entity = coffeeRepository.findById(coffeeIndex).orElse(null);
        if(entity.getCoffee_index() != coffeeIndex || entity.getCoffee_index() ==null){
            throw new IllegalArgumentException("coffee id가 존재 하지 않습니다. ");
        }
        CoffeeDto dto = CoffeeDto.toDtio(entity);
        return dto;
    }
}
