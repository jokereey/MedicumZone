package com.project.medicumzone.controller;

import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.service.ClinicService;
import com.project.medicumzone.io.request.NewClinicRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/clinics")
public class ClinicController {

    private final ClinicService clinicService;

    @GetMapping
    public List<Clinic> getAllClinics(){
        return clinicService.getAllClinics();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping()
    public void addNewClinic(@Valid @RequestBody NewClinicRequest clinicToAdd){
        clinicService.addNewClinic(clinicToAdd);
    }

    @GetMapping("/count")
    public Long count(){
        return clinicService.getNumberOfClinics();
    }
}
