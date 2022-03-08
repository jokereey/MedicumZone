package com.project.medicumzone.io.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewClientRequestModel {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
