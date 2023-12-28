package org.bssm.attachit.domain.attachment.service;

import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.attachment.domain.Attachment;
import org.bssm.attachit.domain.attachment.repository.AttachmentRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AttachmentSchedulerService {

    private final AttachmentRepository attachmentRepository;

    @Scheduled(fixedRate = 1000 * 60 * 10)
    public void deleteExpiredAttachments() {
        List<Attachment> attachments = attachmentRepository.findAll();

        LocalDateTime currentDateTime = LocalDateTime.now();

        for (Attachment attachment : attachments) {
            LocalDateTime attachmentDateTime = attachment.getCreatedDate();

            if (attachmentDateTime != null && currentDateTime.minusHours(4).isAfter(attachmentDateTime)) {
                attachmentRepository.delete(attachment);
            }
        }
    }
}
