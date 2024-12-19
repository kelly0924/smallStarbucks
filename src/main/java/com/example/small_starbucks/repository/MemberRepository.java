package com.example.small_starbucks.repository;

import com.example.small_starbucks.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
