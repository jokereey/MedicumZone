package com.project.medicumzone.io.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

import java.util.Date;

@Getter
@AllArgsConstructor
@ToString
public class AppUserSignUpRequest {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String PESEL;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private boolean newsletter;
}
