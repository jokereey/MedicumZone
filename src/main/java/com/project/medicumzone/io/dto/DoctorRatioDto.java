package com.project.medicumzone.io.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DoctorRatioDto {

    private Long doctorId;
    private String username;
    private String comment;
    private Long ratioValue;

}
