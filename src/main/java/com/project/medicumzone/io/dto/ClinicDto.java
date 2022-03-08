package com.project.medicumzone.io.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClinicDto {
    private String clinicName;
    private String streetName;
    private String zipCode;
    List<DoctorDto> doctorDtoList;
    private String city;
}
