package com.Nekha.freelancer.freelancer.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nekha.freelancer.freelancer.model.skills;
import com.Nekha.freelancer.freelancer.service.skillsService;



@CrossOrigin("*")
@RestController
@RequestMapping("/skills")
public class skillsController {

    @Autowired
    private  skillsService skillService;

    @PostMapping("/submit")
    public String submitSkills(@RequestBody Map<String, Object> requestBody) {
        List<String> skills = (List<String>) requestBody.get("skills");
        int userId = Integer.parseInt((String) requestBody.get("userId"));
        
        // Assuming userId is valid and passed correctly
        
        skillService.saveSkills(skills, userId);
        
        return "Skills submitted successfully!";
    }


    @GetMapping("/user/{userId}")
    public List<skills> getFormsByUserId(@PathVariable int userId) {
        return skillService.getFormsByUserId(userId);
    }
}
