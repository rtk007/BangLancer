package com.Nekha.freelancer.freelancer.service;

import com.Nekha.freelancer.freelancer.model.workHistory;
import com.Nekha.freelancer.freelancer.repository.WorkHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkHistoryService {

    @Autowired
    private  WorkHistoryRepository workHistoryRepository;

    public List<workHistory> getAllWorkHistories() {
        return workHistoryRepository.findAll();
    }

    public List<workHistory> saveWorkHistory(List<workHistory> workHistory) {
        return workHistoryRepository.saveAll(workHistory);
    }

    public List<workHistory> findByUserId(int userId){
        return workHistoryRepository.findByUserId(userId);
    }
}
