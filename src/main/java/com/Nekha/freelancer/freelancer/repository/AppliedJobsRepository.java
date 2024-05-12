package com.Nekha.freelancer.freelancer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nekha.freelancer.freelancer.model.AppliedJobs;
import java.util.List;


public interface AppliedJobsRepository extends JpaRepository<AppliedJobs, Integer> {

    List<AppliedJobs> findByJobOwnerId(int jobOwnerId);

}
