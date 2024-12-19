package com.example.small_starbucks.api;

import com.example.small_starbucks.dto.Memberdto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestApi {
    @PostMapping("/account")
    public ResponseEntity<Memberdto>save(){

        return null;
    }
}
