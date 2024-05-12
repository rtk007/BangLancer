package com.Nekha.freelancer.freelancer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Nekha.freelancer.RequestModel.saveCertificateRequest;
import com.Nekha.freelancer.freelancer.service.CertificateService;


@CrossOrigin("*")
@RestController
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @PostMapping("/certificates/post")
    public ResponseEntity<String> saveCertificates(@RequestBody saveCertificateRequest request) {
        try {
            certificateService.saveCertificates(request.getCertificate(), request.getUserId());
            return ResponseEntity.status(HttpStatus.CREATED).body("Certificates saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save certificates: " + e.getMessage());
        }
    }
}
