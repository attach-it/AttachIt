package org.bssm.attachit.domain.user.presentation.dto.response;

import leehj050211.bsmOauth.type.BsmUserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private String name;
    private BsmUserRole role;
}
