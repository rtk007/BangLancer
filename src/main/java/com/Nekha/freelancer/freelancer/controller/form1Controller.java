package com.Nekha.freelancer.freelancer.controller;

import com.Nekha.freelancer.freelancer.model.form1;
import com.Nekha.freelancer.freelancer.service.form1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/form1")
public class form1Controller {

    @Autowired
    private form1Service form1Service;

    // Create operation
    @PostMapping("/post")
    public form1 createForm1(@RequestBody form1 form) {
        return form1Service.saveOrUpdateForm1(form);
    }

    // Read operation
    @GetMapping("/{id}")
    public form1 getForm1ById(@PathVariable int id) {
        return form1Service.getForm1ById(id);
    }

    // Read operation for all forms
    @GetMapping("/get")
    public List<form1> getAllForm1s() {
        return form1Service.getAllForm1s();
    }

    // Update operation
    @PutMapping("/{id}")
    public form1 updateForm1(@PathVariable int id, @RequestBody form1 form) {
        form.setId(id);
        return form1Service.saveOrUpdateForm1(form);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public void deleteForm1(@PathVariable int id) {
        form1Service.deleteForm1(id);
    }

    @GetMapping("/checkUser/{userId}")
    public boolean isUserPresent(@PathVariable int userId) {
        return form1Service.isUserPresent(userId);
    }


    @GetMapping("/user/{userId}")
    public form1 getFormsByUserId(@PathVariable int userId) {
        return form1Service.getFormsByUserId(userId);
    }
}
