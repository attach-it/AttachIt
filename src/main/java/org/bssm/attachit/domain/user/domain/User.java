package org.bssm.attachit.domain.user.domain;

import jakarta.persistence.*;
import leehj050211.bsmOauth.type.BsmUserRole;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BsmUserRole role;
}
