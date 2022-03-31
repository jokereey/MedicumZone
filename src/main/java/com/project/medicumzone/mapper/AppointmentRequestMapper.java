package com.project.medicumzone.mapper;

import com.project.medicumzone.io.request.AppointmentRequest;
import com.project.medicumzone.io.request.RawAppointmentRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppointmentRequestMapper {

    public AppointmentRequest map(RawAppointmentRequest rawAppointmentRequest){
        var date = rawAppointmentRequest.getAppointmentDate();
        return AppointmentRequest.builder()
                .clinicId(rawAppointmentRequest.getClinicId())
                .doctorId(rawAppointmentRequest.getDoctorId())
                .userId(rawAppointmentRequest.getUserId())
                .date(LocalDateTime.of(date.year,date.month,date.dayOfMonth,date.hour,date.minute))
                .build();
    }

}
