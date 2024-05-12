package com.Nekha.freelancer.freelancer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.Nekha.freelancer.freelancer.model.EducationHistory;
import com.Nekha.freelancer.freelancer.service.EducationHistoryService;

@CrossOrigin("*")
@RestController
public class EducationHistoryController {

    private final EducationHistoryService educationHistoryService;

    public EducationHistoryController(EducationHistoryService educationHistoryService) {
        this.educationHistoryService = educationHistoryService;
    }

    @PostMapping("/api/education-history/post")
    public ResponseEntity<List<EducationHistory>> saveEducationHistory(@RequestBody List<EducationHistory> educationHistories) {
        List<EducationHistory> savedEducationHistories = educationHistoryService.saveEducationHistory(educationHistories);
        return new ResponseEntity<>(savedEducationHistories, HttpStatus.CREATED);
    }


    // http://localhost:8081/api/education-history/find/1

    @GetMapping("/api/education-history/find/{id}")
    List<EducationHistory> findByUserId(@PathVariable int id){
        return  educationHistoryService.findByUserId(id);
    }
}

