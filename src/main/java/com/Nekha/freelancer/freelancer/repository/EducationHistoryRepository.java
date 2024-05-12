package com.Nekha.freelancer.freelancer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nekha.freelancer.freelancer.model.EducationHistory;
import java.util.List;


public interface EducationHistoryRepository extends JpaRepository<EducationHistory, Integer>{
    List<EducationHistory> findByUserId(int userId);
}
