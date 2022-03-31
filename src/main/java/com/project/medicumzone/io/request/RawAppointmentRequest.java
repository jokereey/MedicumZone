package com.project.medicumzone.io.request;

import com.project.medicumzone.io.dto.AppointmentDate;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class RawAppointmentRequest {
    private Long userId;
    private Long doctorId;
    private Long clinicId;

    private AppointmentDate appointmentDate;
}
