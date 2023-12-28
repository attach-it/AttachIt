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
            System.out.println(file);
            // 클라이언트에서 전송한 파일 이름 얻기
            System.out.println(file.getOriginalFilename());

            // 파일 이름 생성 (UUID와 클라이언트에서 전송한 파일 이름 조합)
            String fileName = UUID.randomUUID().toString().replace("-", "") + "_" + file.getOriginalFilename();

            System.out.println(fileName);

            // 파일 경로 설정
            Path path = fileProperties.getPath().resolve(fileName);

            System.out.println(path);

            // 파일 저장
            Files.write(path, file.getBytes(), StandardOpenOption.CREATE);

            System.out.println("clear");

            // 저장된 파일 경로 반환
            return String.format("%s/%s", fileProperties.getPath(), fileName);
        } catch (IOException e) {
            throw FileException.EXCEPTION;
        }
    }
}
