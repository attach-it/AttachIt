package org.bssm.attachit.domain.user.presentation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.user.presentation.dto.response.UserResponse;
import org.bssm.attachit.domain.user.service.GetUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final GetUserService getUserService;

    @GetMapping
    public ResponseEntity<UserResponse> getUserInfo(HttpServletRequest httpServletRequest) {
        return getUserService.execute(httpServletRequest);
    }

}
