package com.project.medicumzone.controller;

import com.project.medicumzone.io.dto.DoctorRatioDto;
import com.project.medicumzone.io.enitity.DoctorRatio;
import com.project.medicumzone.service.DoctorRatioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/doctor-ratio")
public class RatioController {
    private final DoctorRatioService service;

    public RatioController(DoctorRatioService service) {
        this.service = service;
    }

    @PostMapping
    public DoctorRatio addNewRatio(@RequestBody DoctorRatioDto dto ){
        return service.addNew(dto);
    }
}
