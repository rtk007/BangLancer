package com.Nekha.freelancer.freelancer.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nekha.freelancer.freelancer.model.skills;
import com.Nekha.freelancer.freelancer.repository.skillsRespostory;

@Service
public class skillsService {

    @Autowired
    private skillsRespostory skillRepository;

    public void saveSkills(List<String> skills, int userId) {
        for (String skillName : skills) {
            skills skill = new skills();
            skill.setName(skillName);
            skill.setUserId(userId);
            skillRepository.save(skill);
        }
    }


    public List<skills> getFormsByUserId(int userId) {
        return skillRepository.findByUserId(userId);
    }

}
