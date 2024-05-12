package com.Nekha.freelancer.freelancer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nekha.freelancer.freelancer.model.skills;

public interface skillsRespostory extends JpaRepository<skills, Integer>{

    List<skills> findByUserId(int userId);

}
