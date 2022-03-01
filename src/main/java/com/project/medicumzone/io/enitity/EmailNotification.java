package com.project.medicumzone.io.enitity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table()
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmailNotification {

    @Id
    @SequenceGenerator(
            name = "email_sequence",
            sequenceName = "email_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "email_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id")
    private Long id;

    @Column( name = "user_id")
    private Long userId;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "message")
    private String message;


}
