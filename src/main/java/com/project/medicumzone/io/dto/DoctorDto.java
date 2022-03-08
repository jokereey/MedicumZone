package com.project.medicumzone.io.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;
    private String name;
    private String surname;
    private List<SpecializationDto> specializations = new ArrayList<>();
    private ClinicDto clinic;
}
