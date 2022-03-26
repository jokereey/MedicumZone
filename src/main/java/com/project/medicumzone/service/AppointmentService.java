package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.enitity.Appointment;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.io.id.AppointmentID;
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

    public Appointment addNewAppointment(AppointmentRequest appointmentRequest) {
        if (!validateRequest(appointmentRequest)) {
            throw new ApiRequestException("Request contains data that don't exist.");
        } else if (!checkHourCompatibility(appointmentRequest)) {
            throw new ApiRequestException("Appointment date is incorrect. Either clinic is closed or the doctor is not available at this time.");
        } else {
            boolean alreadyTaken =
                    appointmentRepository.existsById(new AppointmentID(appointmentRequest.getDoctorId(),appointmentRequest.getUserId(),appointmentRequest.getClinicId(),appointmentRequest.getDate()));
            if(alreadyTaken){
                throw new ApiRequestException("This date is already taken");
            }
           Doctor doctor = doctorService.getById(appointmentRequest.getDoctorId());
           Clinic clinic = clinicService.getById(appointmentRequest.getClinicId());
           AppUser user = appUserService.getById(appointmentRequest.getUserId());
           Appointment newAppointment = new Appointment(doctor,user,clinic,appointmentRequest.getDate());
           doctor.getAppointments().add(newAppointment);
           clinic.getAppointments().add(newAppointment);
           user.getAppointments().add(newAppointment);
           return appointmentRepository.saveAndFlush(newAppointment);
        }

    }

    protected boolean validateRequest(AppointmentRequest appointmentRequest) {
        return appUserService.existsById(appointmentRequest.getUserId()) &&
                doctorService.existsById(appointmentRequest.getDoctorId()) &&
                clinicService.existsById(appointmentRequest.getClinicId());
    }

    protected boolean checkHourCompatibility(AppointmentRequest request) {
        return clinicService.hourCheck(request)
                && doctorService.hourCheck(request);
    }

}
