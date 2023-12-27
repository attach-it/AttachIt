package org.bssm.attachit.global.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "oauth")
public class AuthProperties {
    private String client_id;
    private String client_secret;
}
