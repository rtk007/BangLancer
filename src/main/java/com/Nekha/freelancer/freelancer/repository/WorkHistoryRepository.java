package com.Nekha.freelancer.freelancer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nekha.freelancer.freelancer.model.workHistory;

public interface WorkHistoryRepository extends JpaRepository<workHistory, Integer> {

    List<workHistory> findByUserId(int userId);
}
