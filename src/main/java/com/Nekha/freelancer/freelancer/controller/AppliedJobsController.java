package com.Nekha.freelancer.freelancer.controller;

import com.Nekha.freelancer.freelancer.model.AppliedJobs;
import com.Nekha.freelancer.freelancer.service.AppliedJobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/appliedjobs")
public class AppliedJobsController {

    @Autowired
    private AppliedJobsService appliedJobsService;

    @GetMapping
    public List<AppliedJobs> getAllAppliedJobs() {
        return appliedJobsService.getAllAppliedJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppliedJobs> getAppliedJobById(@PathVariable int id) {
        Optional<AppliedJobs> appliedJob = appliedJobsService.getAppliedJobById(id);
        return appliedJob.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/apply")
    public ResponseEntity<AppliedJobs> saveAppliedJob(@RequestBody AppliedJobs appliedJobs) {
        AppliedJobs savedAppliedJob = appliedJobsService.saveOrUpdateAppliedJob(appliedJobs);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppliedJob);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppliedJobs> updateAppliedJob(@PathVariable int id, @RequestBody AppliedJobs appliedJobs) {
        if (!appliedJobsService.getAppliedJobById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        appliedJobs.setId(id);
        AppliedJobs updatedAppliedJob = appliedJobsService.saveOrUpdateAppliedJob(appliedJobs);
        return ResponseEntity.ok(updatedAppliedJob);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppliedJob(@PathVariable int id) {
        if (!appliedJobsService.getAppliedJobById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        appliedJobsService.deleteAppliedJob(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find/{id}")
    List<AppliedJobs> findByJobOwnerId(@PathVariable int id){
        return appliedJobsService.findByJobOwnerId(id);
    }
}
