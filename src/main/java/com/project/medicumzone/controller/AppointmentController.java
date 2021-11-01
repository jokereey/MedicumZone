package com.project.medicumzone.controller;

import com.project.medicumzone.request.AppointmentRequest;
import com.project.medicumzone.service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    public ResponseEntity<String> addNewAppointment(@RequestBody AppointmentRequest appointmentRequest){
        appointmentService.addNewAppointment(appointmentRequest);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

}
