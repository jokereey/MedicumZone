package com.project.medicumzone.controller;

import com.project.medicumzone.io.dto.DoctorDto;
import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/doctors")
public class DoctorController {


    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAll(){
        log.info("Getting doctors list at "+ LocalDateTime.now());
        return doctorService.getAll() ;
    }

    @PostMapping
    public Doctor addDoctor(DoctorDto request){
        return null;
    }

}
