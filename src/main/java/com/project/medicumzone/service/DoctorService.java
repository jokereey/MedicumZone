package com.project.medicumzone.service;

import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> getAll(){
        return doctorRepository.findAll();
    }
}
