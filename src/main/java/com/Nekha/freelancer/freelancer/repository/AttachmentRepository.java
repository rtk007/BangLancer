package com.Nekha.freelancer.freelancer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nekha.freelancer.freelancer.model.Attachment;


public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}
