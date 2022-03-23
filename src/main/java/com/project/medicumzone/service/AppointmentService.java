package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.repository.AppUserRepository;
import com.project.medicumzone.repository.AppointmentRepository;
import com.project.medicumzone.io.request.AppointmentRequest;
import com.project.medicumzone.repository.ClinicRepository;
import com.project.medicumzone.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppUserService appUserService;
    private final DoctorService doctorService;
    private final ClinicService clinicService;

    public void addNewAppointment(AppointmentRequest appointmentRequest) {
        if (!validateRequest(appointmentRequest)) {
            throw new ApiRequestException("Request contains data that don't exist.");
        } else if (checkHourCompatibility(appointmentRequest)) {
            throw new ApiRequestException("Appointment date is incorrect. Either clinic is closed or the doctor is not available at this time.");
        } else {
            log.info("Feature is about to be implemented.");
        }

    }

    private boolean validateRequest(AppointmentRequest appointmentRequest) {
        return appUserService.existsById(appointmentRequest.getUserId()) &&
                doctorService.existsById(appointmentRequest.getDoctorId()) &&
                clinicService.existsById(appointmentRequest.getClinicId());
    }

    private boolean checkHourCompatibility(AppointmentRequest request) {
        return clinicService.hourCheck(request.getDate(), request.getClinicId())
                && doctorService.hourCheck(request.getDate(), request.getClinicId(), request.getDoctorId());
    }
}
