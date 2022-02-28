package com.project.medicumzone.io.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class NewClinicRequestModel {
    @NotBlank
    private String clinicName;
    private String streetName;
    private String zipCode;
    private String city;
}
