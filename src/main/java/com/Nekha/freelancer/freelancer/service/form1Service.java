package com.Nekha.freelancer.freelancer.service;

import com.Nekha.freelancer.freelancer.model.form1;
import com.Nekha.freelancer.freelancer.repository.form1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class form1Service {

    @Autowired
    private form1Repository form1Repository;

    // Save or Update operation
    public form1 saveOrUpdateForm1(form1 form) {
        return form1Repository.save(form);
    }

    // Get operation by id
    public form1 getForm1ById(int id) {
        Optional<form1> optionalForm1 = form1Repository.findById(id);
        return optionalForm1.orElse(null);
    }

    // Get operation for all forms
    public List<form1> getAllForm1s() {
        return form1Repository.findAll();
    }

    // Delete operation
    public void deleteForm1(int id) {
        form1Repository.deleteById(id);
    }

    public boolean isUserPresent(int userId) {
        return form1Repository.existsByUserId(userId);
    }

    public form1 getFormsByUserId(int userId) {
        return form1Repository.findByUserId(userId);
    }
}
