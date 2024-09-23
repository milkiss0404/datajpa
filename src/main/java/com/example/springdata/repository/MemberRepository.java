package com.example.springdata.repository;

import com.example.springdata.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);
}
