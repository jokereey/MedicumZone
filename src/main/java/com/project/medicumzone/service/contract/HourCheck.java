package com.project.medicumzone.service.contract;

import com.project.medicumzone.io.request.AppointmentRequest;

import java.time.LocalDateTime;

public interface HourCheck {
    public boolean isAvailableAtThisTime(AppointmentRequest appointmentRequest);
}
