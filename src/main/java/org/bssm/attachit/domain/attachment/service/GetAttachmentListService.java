package org.bssm.attachit.domain.attachment.service;

import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.attachment.presentation.dto.response.AttachmentResponse;
import org.bssm.attachit.domain.attachment.repository.AttachmentRepository;
import org.bssm.attachit.global.properties.FileProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAttachmentListService {

    private final AttachmentRepository attachmentRepository;
    private final FileProperties fileProperties;

    public List<AttachmentResponse> execute() {
        return attachmentRepository.findAll().stream().map(
                attachment -> AttachmentResponse.builder()
                        .content(attachment.getContent())
                        .url(fileProperties.getUrl() + "/file?attachmentId=" + attachment.getId())
                        .name(attachment.getUser().getName())
                        .colorCode(attachment.getColorCode())
                        .postType(attachment.getPostType())
                        .xPosition(attachment.getXPosition())
                        .yPosition(attachment.getYPosition())
                        .zIndex(attachment.getZIndex())
                        .build()
        ).toList();
    }
}
