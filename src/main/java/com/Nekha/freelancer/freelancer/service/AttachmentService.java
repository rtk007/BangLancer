package com.Nekha.freelancer.freelancer.service;

import org.springframework.web.multipart.MultipartFile;

import com.Nekha.freelancer.freelancer.model.Attachment;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
}
