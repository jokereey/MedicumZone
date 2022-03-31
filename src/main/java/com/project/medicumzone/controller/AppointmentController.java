package com.project.medicumzone.controller;

import com.project.medicumzone.io.request.AppointmentRequest;
import com.project.medicumzone.io.request.RawAppointmentRequest;
import com.project.medicumzone.mapper.AppointmentRequestMapper;
import com.project.medicumzone.service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private AppointmentRequestMapper appointmentRequestMapper;

    @PostMapping
    public ResponseEntity<String> addNewAppointment(@RequestBody RawAppointmentRequest rawAppointmentRequest){

        appointmentService.addNewAppointment(appointmentRequestMapper.map(rawAppointmentRequest));
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

}
