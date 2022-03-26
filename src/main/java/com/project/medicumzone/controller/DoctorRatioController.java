package com.project.medicumzone.controller;

import com.project.medicumzone.io.dto.DoctorRatioDto;
import com.project.medicumzone.service.DoctorRatioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/doctor-ratio")
@Slf4j
public class DoctorRatioController {
    private final DoctorRatioService service;

    public DoctorRatioController(DoctorRatioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addNewRatio(@RequestBody DoctorRatioDto dto) {
        log.info("RATIO-CONTROLLER: incoming request with data: +" + dto.toString());
        service.addNew(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
