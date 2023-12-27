package org.bssm.attachit.domain.attachment.domain;

import jakarta.persistence.*;
import lombok.*;
import org.bssm.attachit.domain.user.domain.User;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private String path;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
