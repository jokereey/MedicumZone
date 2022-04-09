package com.project.medicumzone.io.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class NewClinicRequest {

    private String clinicName;

    private String streetName;

    private String zipCode;

    private String city;
}
