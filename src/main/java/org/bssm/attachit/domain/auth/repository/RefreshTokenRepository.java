package org.bssm.attachit.domain.auth.repository;

import org.bssm.attachit.domain.auth.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    boolean existsByAccessToken(String token);

    Optional<RefreshToken> findByEmail(String email);
}
