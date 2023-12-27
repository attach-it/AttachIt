package org.bssm.attachit.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.auth.domain.RefreshToken;
import org.bssm.attachit.domain.auth.presentation.dto.response.TokenResponse;
import org.bssm.attachit.domain.auth.repository.RefreshTokenRepository;
import org.bssm.attachit.global.jwt.util.JwtProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaveRefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProvider jwtProvider;

    public ResponseEntity<TokenResponse> execute(String email) {
        String accessToken = jwtProvider.createAccessToken(email);
        String refreshToken = jwtProvider.createRefreshToken(email);

        Optional<RefreshToken> refresh_token = refreshTokenRepository.findByEmail(email);

        if (refresh_token.isEmpty()) {
            refreshTokenRepository.save(
                    RefreshToken.builder()
                            .email(email)
                            .accessToken(accessToken)
                            .refreshToken(refreshToken)
                            .build()
            );
        }
        else {
            refresh_token.get().setAccessToken(accessToken);
            refresh_token.get().setRefreshToken(refreshToken);
            refreshTokenRepository.save(refresh_token.get());
        }
        return ResponseEntity.ok(TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build());
    }
}
