package org.bssm.attachit.domain.attachment.service;

import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.attachment.exception.FileException;
import org.bssm.attachit.global.properties.FileProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FileSaveUtil {

    private final FileProperties fileProperties;

    public String save(MultipartFile file) {
        try {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path path = fileProperties.getPath().resolve(
                    Paths.get(fileName)
                            .normalize());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return String.format("%s/%s", fileProperties.getPath(), fileName);
        } catch (IOException e) {
            throw FileException.EXCEPTION;
        }
    }
}
