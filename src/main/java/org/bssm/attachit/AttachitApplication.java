package org.bssm.attachit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class AttachitApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttachitApplication.class, args);
    }

}
