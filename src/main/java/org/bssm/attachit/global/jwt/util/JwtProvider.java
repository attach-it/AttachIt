package org.bssm.attachit.global.jwt.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.bssm.attachit.global.jwt.properties.JwtProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties jwtProperties;
    public String createAccessToken(String email) {
        return createToken(email, jwtProperties.getAccessExp());
    }

    public String createRefreshToken(String email) {
        return createToken(email, jwtProperties.getRefreshExp());
    }

    private String createToken(String email, long expirationTime) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(email)
                .claim("email", email)
                .signWith(jwtProperties.getSecret(), SignatureAlgorithm.HS256)
                .setExpiration(new Date(now.getTime() + expirationTime))
                .compact();

    }
}
