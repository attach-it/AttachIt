package org.bssm.attachit.domain.attachment.domain;

import jakarta.persistence.*;
import lombok.*;
import org.bssm.attachit.domain.attachment.domain.type.PostType;
import org.bssm.attachit.domain.user.domain.User;
import org.bssm.attachit.global.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Attachment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private String path;

    @Column
    private Long colorCode;

    @Column
    private Long zIndex;

    @Column
    @Enumerated(EnumType.STRING)
    private PostType postType;

    @Column
    private String xPosition;

    @Column
    private String yPosition;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
