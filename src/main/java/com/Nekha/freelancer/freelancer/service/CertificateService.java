package com.Nekha.freelancer.freelancer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nekha.freelancer.freelancer.model.Certificate;
import com.Nekha.freelancer.freelancer.repository.CertificateRepository;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;


    public void saveCertificates(List<String> certificates, int userId) {
        for (String certificateName : certificates) {
            Certificate certificate = new Certificate();
            certificate.setCertificate(certificateName);
            certificate.setUserId(userId);
            certificateRepository.save(certificate);
        }
    }

}
