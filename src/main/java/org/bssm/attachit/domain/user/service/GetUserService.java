package org.bssm.attachit.domain.user.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.user.domain.User;
import org.bssm.attachit.domain.user.exception.UserNotFoundException;
import org.bssm.attachit.domain.user.presentation.dto.response.UserResponse;
import org.bssm.attachit.domain.user.repository.UserRepository;
import org.bssm.attachit.global.jwt.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public ResponseEntity<UserResponse> execute(HttpServletRequest httpServletRequest) {
        User user = userRepository.findByEmail(jwtUtil.extractEmail(httpServletRequest)).orElseThrow(
                () -> UserNotFoundException.EXCEPTION
        );
        return ResponseEntity.ok(UserResponse.builder()
                .name(user.getName())
                .role(user.getRole())
                .build());
    }
}
