package org.bssm.attachit.domain.auth.presentation;

import leehj050211.bsmOauth.exception.BsmOAuthCodeNotFoundException;
import leehj050211.bsmOauth.exception.BsmOAuthInvalidClientException;
import leehj050211.bsmOauth.exception.BsmOAuthTokenNotFoundException;
import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.auth.presentation.dto.response.TokenResponse;
import org.bssm.attachit.domain.auth.service.UserLoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserLoginService userLoginService;

    @PostMapping
    public ResponseEntity<TokenResponse> signIn(@RequestParam("code") String code) throws BsmOAuthInvalidClientException, IOException, BsmOAuthCodeNotFoundException, BsmOAuthTokenNotFoundException {
        return userLoginService.execute(code);
    }
}
