package com.project.medicumzone.io.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class NewClinicRequestModel {
    @NotBlank
    private String clinicName;
    @NotBlank
    private String streetName;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String city;
}
