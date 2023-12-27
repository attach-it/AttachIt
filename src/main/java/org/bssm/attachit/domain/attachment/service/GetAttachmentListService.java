package org.bssm.attachit.domain.attachment.service;

import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.attachment.domain.Attachment;
import org.bssm.attachit.domain.attachment.repository.AttachmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAttachmentListService {

    private final AttachmentRepository attachmentRepository;

    public List<Attachment> execute() {
        return attachmentRepository.findAll();
    }
}
