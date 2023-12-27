package org.bssm.attachit.domain.attachment.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.bssm.attachit.domain.attachment.domain.type.PostType;

@Getter
@Builder
public class AttachmentResponse {
    private String content;
    private String url;
    private Long colorCode;
    private Long zIndex;
    private PostType postType;
    private String xPosition;
    private String yPosition;
    private String name;
}
