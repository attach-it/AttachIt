package org.bssm.attachit.domain.auth.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.auth.repository.RefreshTokenRepository;
import org.bssm.attachit.global.jwt.exception.TokenNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserSignOutService {

    private final RefreshTokenRepository refreshTokenRepository;
    public ResponseEntity<String> execute(HttpServletRequest httpServletRequest) {
        String refreshToken = httpServletRequest.getHeader("Authorization-refresh").split(" ")[1].trim();
        if (refreshToken.isEmpty()) {
            throw TokenNotFoundException.EXCEPTION;
        }
        refreshTokenRepository.deleteByRefreshToken(refreshToken);
        return ResponseEntity.ok("success");
    }
}
