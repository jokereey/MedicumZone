package com.project.medicumzone.io.enitity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NewsletterNotification {
    @Id
    @SequenceGenerator(
            name = "newsletter_sequence",
            sequenceName = "newsletter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "newsletter_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "message")
    private String message;

}
