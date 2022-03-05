package com.project.medicumzone.service;

import com.project.medicumzone.repository.AppointmentRepository;
import com.project.medicumzone.io.request.AppointmentRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {


    private final AppointmentRepository appointmentRepository;

    public void addNewAppointment(AppointmentRequest appointmentRequest){
        //TODO: NEW APPOINTMENT IMPLEMENTATION
    }
}
