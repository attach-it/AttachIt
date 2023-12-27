package org.bssm.attachit.domain.attachment.presentation.dto.request;

import lombok.Getter;
import org.bssm.attachit.domain.attachment.domain.type.PostType;

@Getter
public class PostAttachmentRequest {
    private String content;
    private Long colorCode;
    private Long zIndex;
    private PostType postType;
    private String xPosition;
    private String yPosition;
}
