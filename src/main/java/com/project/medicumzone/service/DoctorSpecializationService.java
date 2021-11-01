package com.project.medicumzone.service;

import com.project.medicumzone.repository.DoctorSpecializationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorSpecializationService {

    @Autowired
    private final DoctorSpecializationRepository specializationRepository;
}
