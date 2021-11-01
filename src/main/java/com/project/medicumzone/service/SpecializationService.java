package com.project.medicumzone.service;

import com.project.medicumzone.repository.SpecializationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpecializationService {

    @Autowired
    private final SpecializationRepository specializationRepository;
}
