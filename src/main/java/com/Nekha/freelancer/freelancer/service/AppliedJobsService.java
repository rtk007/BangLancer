package com.Nekha.freelancer.freelancer.service;

import com.Nekha.freelancer.freelancer.model.AppliedJobs;
import com.Nekha.freelancer.freelancer.repository.AppliedJobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppliedJobsService {

    @Autowired
    private AppliedJobsRepository appliedJobsRepository;

    public List<AppliedJobs> getAllAppliedJobs() {
        return appliedJobsRepository.findAll();
    }

    public Optional<AppliedJobs> getAppliedJobById(int id) {
        return appliedJobsRepository.findById(id);
    }

    public AppliedJobs saveOrUpdateAppliedJob(AppliedJobs appliedJobs) {
        return appliedJobsRepository.save(appliedJobs);
    }

    public void deleteAppliedJob(int id) {
        appliedJobsRepository.deleteById(id);
    }
    
    public List<AppliedJobs> findByJobOwnerId(int jobOwnerId){
        return appliedJobsRepository.findByJobOwnerId(jobOwnerId);
    }
}
