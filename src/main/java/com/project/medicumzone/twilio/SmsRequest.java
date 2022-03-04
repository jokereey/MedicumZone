package com.project.medicumzone.twilio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SmsRequest {
    @NotBlank
    private  String phoneNumber;
    @NotBlank
    private  String message;

}
