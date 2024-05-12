package com.Nekha.freelancer.freelancer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nekha.freelancer.freelancer.model.form1;

public interface form1Repository extends JpaRepository<form1, Integer> {
    boolean existsByUserId(int user_id);

    form1 findByUserId(int userId);
}
