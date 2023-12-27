package org.bssm.attachit.domain.file.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.attachment.domain.Attachment;
import org.bssm.attachit.domain.attachment.exception.FileNotFoundException;
import org.bssm.attachit.domain.attachment.repository.AttachmentRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class GetFileService {

    private final AttachmentRepository attachmentRepository;

    public ResponseEntity<Resource> execute(Long id, HttpServletRequest httpServletRequest) throws IOException {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(
                () -> FileNotFoundException.EXCEPTION
        );
        Path path = Paths.get(attachment.getPath());
        Resource resource = new UrlResource(path.toUri());
        String contentType = httpServletRequest.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(contentType)
                .body(resource);
    }
}
