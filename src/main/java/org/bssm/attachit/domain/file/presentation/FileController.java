package org.bssm.attachit.domain.file.presentation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.file.service.GetFileService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final GetFileService getFileService;

    @GetMapping
    public ResponseEntity<Resource> getFile(@RequestParam("attachmentId") Long id, HttpServletRequest httpServletRequest) throws IOException {
        return getFileService.execute(id, httpServletRequest);
    }

}
