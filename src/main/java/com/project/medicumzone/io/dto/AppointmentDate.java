package com.project.medicumzone.io.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDate {
    public int year;
    public int month;
    public int dayOfMonth;
    public int hour;
    public int minute;
}
