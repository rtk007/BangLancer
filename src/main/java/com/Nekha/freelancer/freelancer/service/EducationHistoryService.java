package com.Nekha.freelancer.freelancer.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.Nekha.freelancer.freelancer.model.EducationHistory;
import com.Nekha.freelancer.freelancer.repository.EducationHistoryRepository;

@Service
public class EducationHistoryService {

    private final EducationHistoryRepository educationHistoryRepository;

    public EducationHistoryService(EducationHistoryRepository educationHistoryRepository) {
        this.educationHistoryRepository = educationHistoryRepository;
    }

    public List<EducationHistory> saveEducationHistory(List<EducationHistory> educationHistories) {
        return educationHistoryRepository.saveAll(educationHistories);
    }


    public List<EducationHistory> findByUserId(int userId){
        return educationHistoryRepository.findByUserId(userId);
    }
}