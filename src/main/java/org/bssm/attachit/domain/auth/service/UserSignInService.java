package org.bssm.attachit.domain.auth.service;

import leehj050211.bsmOauth.BsmOauth;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import leehj050211.bsmOauth.exception.BsmOAuthCodeNotFoundException;
import leehj050211.bsmOauth.exception.BsmOAuthInvalidClientException;
import leehj050211.bsmOauth.exception.BsmOAuthTokenNotFoundException;
import leehj050211.bsmOauth.type.BsmUserRole;
import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.auth.presentation.dto.response.TokenResponse;
import org.bssm.attachit.domain.user.domain.User;
import org.bssm.attachit.domain.user.repository.UserRepository;
import org.bssm.attachit.global.properties.AuthProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserSignInService {

    private final UserRepository userRepository;
    private final AuthProperties authProperties;
    private final SaveRefreshTokenService saveRefreshTokenService;

    public ResponseEntity<TokenResponse> execute(String code) throws BsmOAuthInvalidClientException, IOException, BsmOAuthCodeNotFoundException, BsmOAuthTokenNotFoundException {
        BsmOauth bsmOauth = new BsmOauth(authProperties.getClient_id(), authProperties.getClient_secret());
        String token = bsmOauth.getToken(code);
        BsmUserResource resource = bsmOauth.getResource(token);
        if (userRepository.findByEmail(resource.getEmail()).isEmpty()) {
            userRepository.save(User.builder()
                    .name(resource.getRole() == BsmUserRole.TEACHER ? resource.getTeacher().getName() : resource.getStudent().getName())
                    .email(resource.getEmail())
                    .role(resource.getRole())
                    .build()
            );
        }
        return saveRefreshTokenService.execute(resource.getEmail());
    }
}
