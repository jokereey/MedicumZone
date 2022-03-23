package com.project.medicumzone.service;

import com.project.medicumzone.repository.AppUserRepository;
import com.project.medicumzone.repository.AppointmentRepository;
import com.project.medicumzone.io.request.AppointmentRequest;
import com.project.medicumzone.repository.ClinicRepository;
import com.project.medicumzone.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppUserService appUserService;
    private final DoctorService doctorService;
    private final ClinicService clinicService;

    public void addNewAppointment(AppointmentRequest appointmentRequest) {
        if      (appUserService.existsById(appointmentRequest.getUserId()) &&
                doctorService.existsById(appointmentRequest.getDoctorId()) &&
                clinicService.existsById(appointmentRequest.getClinicId())) {


        }
    }
}
