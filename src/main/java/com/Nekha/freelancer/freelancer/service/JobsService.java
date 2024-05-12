package com.Nekha.freelancer.freelancer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nekha.freelancer.freelancer.model.Jobs;
import com.Nekha.freelancer.freelancer.repository.JobsRepo;

@Service
public class JobsService {
    
    @Autowired
    private JobsRepo jobsRepo;

    // Method to save a job
    public Jobs saveJob(Jobs job) {
        return jobsRepo.save(job);
    }
    
    // Method to find a job by its id
    public Optional<Jobs> findJobById(Integer id) {
        return jobsRepo.findById(id);
    }
    
    // Method to retrieve all jobs
    public List<Jobs> findAllJobs() {
        return jobsRepo.findAll();
    }
    
    // Method to update a job
    public Jobs updateJob(Jobs job) {
        return jobsRepo.save(job);
    }
    
    // Method to delete a job by its id
    public void deleteJob(Integer id) {
        jobsRepo.deleteById(id);
    }
}
