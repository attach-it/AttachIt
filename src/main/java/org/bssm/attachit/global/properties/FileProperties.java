package org.bssm.attachit.global.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "root")
public class FileProperties {
    private Path path;
    private String url;
}
