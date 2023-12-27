package org.bssm.attachit.domain.attachment.presentation.dto.request;

import lombok.Getter;
import org.bssm.attachit.domain.attachment.domain.type.PostType;

@Getter
public class PostAttachmentRequest {
    private String content;
    private Long colorCode;
    private PostType postType;
    private Long z;
    private String x;
    private String y;
}
