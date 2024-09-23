package com.example.springdata.repository;

import com.example.springdata.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository <Team,Long> {
}
