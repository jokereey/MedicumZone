package com.project.medicumzone.io.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DoctorRatioDto {

    private Long doctorId;
    private String username;
    private String comment;
    private double ratioValue;

}
