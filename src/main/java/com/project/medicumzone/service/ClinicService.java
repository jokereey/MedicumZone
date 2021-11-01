package com.project.medicumzone.service;

import com.project.medicumzone.repository.ClinicRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClinicService {

    @Autowired
    private final ClinicRepository clinicRepository;
}
