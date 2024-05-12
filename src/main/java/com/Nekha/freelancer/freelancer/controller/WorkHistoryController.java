package com.Nekha.freelancer.freelancer.controller;

import com.Nekha.freelancer.freelancer.model.workHistory;
import com.Nekha.freelancer.freelancer.service.WorkHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/work-history")
public class WorkHistoryController {

    @Autowired
    private  WorkHistoryService workHistoryService;

    

    @GetMapping
    public ResponseEntity<List<workHistory>> getAllWorkHistories() {
        List<workHistory> workHistories = workHistoryService.getAllWorkHistories();
        return new ResponseEntity<>(workHistories, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<List<workHistory>> saveWorkHistory(@RequestBody List<workHistory> workHistories) {
        List<workHistory> savedWorkHistories = workHistoryService.saveWorkHistory(workHistories);
        return new ResponseEntity<>(savedWorkHistories, HttpStatus.CREATED);
    }

    @GetMapping("/find/{userId}")
    public List<workHistory> findByUserId(@PathVariable int userId){
        return workHistoryService.findByUserId(userId);
    }


}