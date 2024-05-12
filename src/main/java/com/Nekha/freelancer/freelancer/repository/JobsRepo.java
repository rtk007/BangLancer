package com.Nekha.freelancer.freelancer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nekha.freelancer.freelancer.model.Jobs;

public interface JobsRepo extends JpaRepository<Jobs, Integer> {

}
