package com.example.small_starbucks.service;

import com.example.small_starbucks.dto.CoffeeDto;
import com.example.small_starbucks.entity.Coffee;
import com.example.small_starbucks.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
