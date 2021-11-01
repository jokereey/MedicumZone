package com.project.medicumzone.service;

import com.project.medicumzone.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
}
