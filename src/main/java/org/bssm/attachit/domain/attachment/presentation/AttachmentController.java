package org.bssm.attachit.domain.attachment.presentation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.attachment.presentation.dto.request.PostAttachmentRequest;
import org.bssm.attachit.domain.attachment.service.PostAttachmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attachment")
public class AttachmentController {

    private final PostAttachmentService postAttachmentService;
    @PostMapping
    public ResponseEntity<String> createPost(@RequestPart("data") PostAttachmentRequest request, @RequestPart("file") MultipartFile file, HttpServletRequest httpServletRequest) {
        return postAttachmentService.execute(request, file, httpServletRequest);
    }
}
