package com.project.medicumzone.io.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class AppUserSignUpRequest {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String PESEL;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dob;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private boolean newsletter;
}
