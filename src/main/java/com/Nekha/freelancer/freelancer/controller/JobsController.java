package com.Nekha.freelancer.freelancer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Nekha.freelancer.freelancer.model.Jobs;
import com.Nekha.freelancer.freelancer.service.JobsService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/jobs")
public class JobsController {

    @Autowired
    private JobsService jobsService;

    // Endpoint to create a new job
    @PostMapping("/create")
    public ResponseEntity<Jobs> createJob(@RequestBody Jobs job) {
        Jobs createdJob = jobsService.saveJob(job);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    // Endpoint to get all jobs
    @GetMapping("/all")
    public ResponseEntity<List<Jobs>> getAllJobs() {
        List<Jobs> jobs = jobsService.findAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    // Endpoint to get a job by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Jobs> getJobById(@PathVariable Integer id) {
        Optional<Jobs> job = jobsService.findJobById(id);
        return job.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to update a job
    @PutMapping("/update")
    public ResponseEntity<Jobs> updateJob(@RequestBody Jobs job) {
        Jobs updatedJob = jobsService.updateJob(job);
        return new ResponseEntity<>(updatedJob, HttpStatus.OK);
    }

    // Endpoint to delete a job by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Integer id) {
        jobsService.deleteJob(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
